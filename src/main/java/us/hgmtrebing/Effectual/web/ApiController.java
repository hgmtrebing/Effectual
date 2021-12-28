package us.hgmtrebing.Effectual.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.Effectual.database.ProjectRepository;
import us.hgmtrebing.Effectual.database.UserRepository;
import us.hgmtrebing.Effectual.impl.Project;
import us.hgmtrebing.Effectual.impl.User;

import java.util.List;

@RestController
public class ApiController {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public ApiController(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
