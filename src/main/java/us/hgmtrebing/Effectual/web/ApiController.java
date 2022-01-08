package us.hgmtrebing.Effectual.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.Effectual.database.DatabaseService;
import us.hgmtrebing.Effectual.impl.User;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private DatabaseService databaseService;

    public ApiController() {
    }

    @GetMapping("/dev/all-users")
    public List<User> showAllUsers() {
        return this.databaseService.getAllUsers();
    }

}
