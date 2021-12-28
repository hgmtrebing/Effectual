package us.hgmtrebing.Effectual.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.Effectual.database.UserRepository;
import us.hgmtrebing.Effectual.impl.UserImpl;

import java.util.List;

@RestController
public class ApiController {
    private final UserRepository userRepository;

    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserImpl> getAllUsers() {
        return userRepository.findAll();
    }
}
