package us.hgmtrebing.Effectual.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.hgmtrebing.Effectual.impl.TodoElementTree;
import us.hgmtrebing.Effectual.impl.User;

import java.util.List;

@Service
public class DatabaseService {

    private static final Logger log = LoggerFactory.getLogger(DatabaseService.class);
    private final Configuration config;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoElementRepository todoElementRepository;

    @Autowired
    private TodoElementStatusRepository todoElementStatusRepository;

    @Autowired
    TodoElementTypeRepository todoElementTypeRepository;

    @Autowired
    TodoElementTreeRepository todoElementTreeRepository;

    public DatabaseService() {

        this.config = new Configuration();
        config.configure();

        this.initializeEnvironment();
    }

    public void initializeEnvironment() {
    }

    public Session createSession() {
        return this.config.buildSessionFactory().openSession();
    }

    public boolean persistObject(Object object) {
        Session session = createSession();
        try {
            Transaction t = session.beginTransaction();

            session.persist(object);
            session.flush();
            t.commit();
            session.close();

            return true;
        } catch (Exception e) {
            log.warn("Error encountered when trying to persist Object: {}", e.toString());
            return false;
        }
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<TodoElementTree> getAllElementTrees() {
        return this.todoElementTreeRepository.findAll();
    }


}
