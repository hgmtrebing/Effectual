package us.hgmtrebing.Effectual.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_projects")
public class Project extends Element{

    private static final Logger log = LoggerFactory.getLogger(Project.class);
    public static final Project ROOT_PROJECT = new Project("ROOT", "ROOT", null);

    @OneToOne
    private Project parent;

    @OneToMany
    private List<Project> children; // TODO - should probably be a Set

    public Project(String name, String description, User user) {
        super(name, description, user);
        this.parent = ROOT_PROJECT;
        this.children = new ArrayList<>();
    }

    public Project() {
        super();
        this.parent = ROOT_PROJECT;
    }

    public Project getParent() {
        return this.parent;
    }

    public void setParent(Project newParent) {
        if (!isValidParent(newParent)) {
            log.warn("Attempted to set an Invalid Project as a Parent!");
            return;
        }

        this.parent = newParent;

    }

    private boolean isValidParent(Project project) {
        while (!project.equals(ROOT_PROJECT)) {

            if (project == null) {
                return false;
            }

            if (this.equals(project)) {
                return false;
            }
        }

        return true;
    }

    public void addChild(Project newChild) {
        this.children.add(newChild);
    }
}
