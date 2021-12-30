package us.hgmtrebing.Effectual.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_projects")
public class Project extends Element{

    public static final Project ROOT_PROJECT = new Project("ROOT", "ROOT", null);

    @OneToOne
    private Project parent;

    public Project(String name, String description, User user) {
        super(name, description, user);
        this.parent = ROOT_PROJECT;
    }

    public Project() {
        super();
        this.parent = ROOT_PROJECT;
    }

    public Project getParent() {
        return this.parent;
    }

    public void setParent(Project newParent) {
        this.parent = newParent;
    }
}
