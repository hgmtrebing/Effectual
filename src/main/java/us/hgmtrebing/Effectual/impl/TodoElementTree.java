package us.hgmtrebing.Effectual.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import us.hgmtrebing.Effectual.database.DatabaseService;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="todo_element_trees")
public class TodoElementTree {
    private static final Logger log = LoggerFactory.getLogger(TodoElementTree.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JoinColumn(name = "root_element_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private TodoElement rootElement;

    @JoinColumn
    @ManyToOne
    private User owner;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @MapKey(name = "name")
    private Map<String, TodoElementStatus> statuses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @MapKey(name = "name")
    private Map<String, TodoElementType> types;

    protected TodoElementTree() { }

    public void initializeDefaultStatuses() {
        this.addNewStatusIfNotExists("N/A", "");
        this.addNewStatusIfNotExists("New", "");
        this.addNewStatusIfNotExists("In-Progress", "");
        this.addNewStatusIfNotExists("On-Hold", "");
        this.addNewStatusIfNotExists("Completed", "");
    }

    public TodoElementStatus addNewStatusIfNotExists(String name, String description) {
        if (this.statuses.containsKey(name)) {
            return this.statuses.get(name);
        }

        TodoElementStatus status = new TodoElementStatus(name, description, this);
        this.statuses.put(name, status);
        return status;
    }

    public void initializeDefaultTypes() {
        this.addNewTypeIfNotExists("Simple", "");
        this.addNewTypeIfNotExists("Task", "");
        this.addNewTypeIfNotExists("Project", "");
        this.addNewTypeIfNotExists("Event", "");
        this.addNewTypeIfNotExists("Meeting", "");
        this.addNewTypeIfNotExists("Appointment", "");
        this.addNewTypeIfNotExists("Goal", "");
        this.addNewTypeIfNotExists("Theater", "");
    }

    public void initializeRootElement() {
        if (this.rootElement == null) {
            TodoElement element = new TodoElement(this.getName(), this.getDescription(), this.getOwner(), null);
            this.setRootElement(element);
            TodoElementType type = this.addNewTypeIfNotExists("N/A", "Not Applicable");
            TodoElementStatus status = this.addNewStatusIfNotExists("Simple", "Simple Element");
            this.getRootElement().setElementType(type);
            this.getRootElement().setElementStatus(status);
        }
    }

    public TodoElementType addNewTypeIfNotExists(String name, String description) {
        if (this.types.containsKey(name)) {
            return this.types.get(name);
        }

        TodoElementType type = new TodoElementType(name, description, this);
        this.types.put(name, type);
        return type;
    }

    public void setParentChildRelationship(TodoElement parent, TodoElement child) throws InvalidParentChildRelationshipException{

        if (isAncestor(parent, child)) {
            throw new InvalidParentChildRelationshipException();
        }

        if (child.getParent() != null) {
            TodoElement oldParent = child.getParent();
            oldParent.getChildren().remove(child);
        }

        parent.getChildren().add(child);
        child.setParent(parent);
    }

    /**
     * Determines whether a given TodoElement has a valid ancestory that traces back to this tree's
     * Root Element, with no cycles.
     * @param element the element whose ancestory to inspect.
     * @return true if the ancestory is valid; false otherwise
     */
    public boolean hasValidAncestory(TodoElement element) {
        Set<TodoElement> seenElements = new HashSet<>();
        TodoElement currentElement = element;
        while (true) {

            if (currentElement == null) {
                return false;
            }

            if (seenElements.contains(currentElement)) {
                return false;
            }

            if (currentElement.equals(this.getRootElement())) {
                return true;
            }

            seenElements.add(currentElement);
            currentElement = currentElement.getParent();
        }
    }

    public boolean isAncestor(TodoElement element, TodoElement possibleAncestor) {
        Set<TodoElement> seenElements = new HashSet<>();
        TodoElement currentElement = element;

        while (true) {

            if (currentElement.equals(possibleAncestor)) {
                return true;
            }

            if (seenElements.contains(currentElement)) {
                return false;
            }

            if (currentElement.equals(this.getRootElement())) {
                return false;
            }

            seenElements.add(currentElement);
            currentElement = element.getParent();
        }
    }

    public boolean isDescendant(TodoElement element, TodoElement possibleDescendant) {
        return this.isAncestor(possibleDescendant, element);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TodoElement getRootElement() {
        return rootElement;
    }

    public void setRootElement(TodoElement rootElement) {
        this.rootElement = rootElement;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, TodoElementStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Map<String, TodoElementStatus> statuses) {
        this.statuses = statuses;
    }

    public Map<String, TodoElementType> getTypes() {
        return types;
    }

    public void setTypes(Map<String, TodoElementType> types) {
        this.types = types;
    }
}
