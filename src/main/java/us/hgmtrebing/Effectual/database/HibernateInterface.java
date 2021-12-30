package us.hgmtrebing.Effectual.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.hgmtrebing.Effectual.impl.Project;

@Component
public class HibernateInterface {

    private static final Logger log = LoggerFactory.getLogger(HibernateInterface.class);
    private final Configuration config;

    public HibernateInterface() {

        this.config = new Configuration();
        config.configure();

        this.initializeEnvironment();
    }

    public void initializeEnvironment() {
        persistObject(Project.ROOT_PROJECT);
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
}
