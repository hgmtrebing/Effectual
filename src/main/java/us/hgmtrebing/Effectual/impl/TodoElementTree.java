package us.hgmtrebing.Effectual.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import us.hgmtrebing.Effectual.database.DatabaseService;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="todo_element_trees")
public class TodoElementTree {
    private static final Logger log = LoggerFactory.getLogger(TodoElementTree.class);

    @Id
    @GeneratedValue
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
    @JoinTable(name = "statuses",
            joinColumns = {@JoinColumn(name = "tree_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")})
    @MapKey(name = "name")
    private Map<String, TodoElementStatus> statuses;

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
}
