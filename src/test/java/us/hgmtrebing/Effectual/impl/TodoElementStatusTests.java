package us.hgmtrebing.Effectual.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoElementStatusTests {

    @Test
    public void singleEmptyStatusTest() {
        TodoElementStatus status = new TodoElementStatus();
        Assertions.assertEquals(status, status);
        Assertions.assertEquals(status.hashCode(), status.hashCode());
    }
}
