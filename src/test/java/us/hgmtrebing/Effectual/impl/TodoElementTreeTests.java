package us.hgmtrebing.Effectual.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import us.hgmtrebing.Effectual.database.DatabaseService;

public class TodoElementTreeTests {

    @BeforeAll
    public static void setup() {
        factory = new TodoElementTreeFactory(Mockito.mock(DatabaseService.class));
    }

    private static TodoElementTreeFactory factory;

    @Test
    public void ancestoryTest01() {
        TodoElementTree tree = factory.createTodoElementTree("Test", "Test", new User());

    }
}
