package us.hgmtrebing.Effectual.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.hgmtrebing.Effectual.database.DatabaseService;

import java.util.HashMap;

@Component
public class TodoElementTreeFactory {

    @Autowired
    private DatabaseService databaseService;

    public TodoElementTreeFactory() { }

    public TodoElementTreeFactory(DatabaseService service) {
        this.databaseService = service;
    }

    public TodoElementTree createTodoElementTree(String name, String description, User user) {
        if (name == null || description == null || user == null) {
            // TODO - throw exception and/or log message
            return null;
        }

        TodoElementTree tree = new TodoElementTree();
        tree.setOwner(user);
        tree.setName(name);
        tree.setDescription(description);
        tree.setStatuses(new HashMap<>());
        tree.setTypes(new HashMap<>());
        tree.initializeDefaultStatuses();
        tree.initializeDefaultTypes();
        tree.initializeRootElement();

        this.databaseService.persistObject(tree);
        return tree;
    }

    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
}
