package us.hgmtrebing.Effectual.impl;

import org.springframework.beans.factory.annotation.Autowired;
import us.hgmtrebing.Effectual.database.DatabaseService;

import javax.persistence.*;

@Entity
@Table(name="todo_element_trees")
public class TodoElementTree {

    @Autowired
    @Transient
    private DatabaseService databaseService;

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @JoinColumn
    @OneToOne
    private TodoElement rootElement;

    @JoinColumn
    @ManyToOne
    private User owner;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    protected TodoElementTree() { }


    public static TodoElementTree createTodoElementTree(String name, String description, User user) {
        if (name == null || description == null || user == null) {
            // TODO - throw exception and/or log message
            return null;
        }

        TodoElementTree tree = new TodoElementTree();
        tree.setOwner(user);
        tree.setName(name);
        tree.setDescription(description);
        tree.setRootElement(new TodoElement(name, description, user));

        if (tree.databaseService.persistObject(tree)) {
            return tree;
        } else {
            // TODO - throw exception and/or log message
            return null;
        }
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
}
