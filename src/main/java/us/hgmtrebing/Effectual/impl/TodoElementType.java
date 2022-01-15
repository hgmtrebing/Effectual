package us.hgmtrebing.Effectual.impl;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="todo_element_types")
public class TodoElementType {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @JoinColumn
    @ManyToOne
    private TodoElementTree tree;

    public TodoElementType() { }

    public TodoElementType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public TodoElementTree getTree() {
        return tree;
    }

    public void setTree(TodoElementTree tree) {
        this.tree = tree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoElementType that = (TodoElementType) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(tree, that.tree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, tree);
    }
}
