package us.hgmtrebing.Effectual;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.hgmtrebing.Effectual.cli.InteractiveCommandLine;
import us.hgmtrebing.Effectual.database.UserService;
import us.hgmtrebing.Effectual.impl.UserImpl;

@SpringBootApplication
public class EffectualApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EffectualApplication.class);

	public static void main(String[] args) {
		log.info("Initializing Effectual Application.");
		SpringApplication.run(EffectualApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testPersistUser();
	}

	public void initializeCommandLine() {
		log.info("Beginning Command Line Runner ...");
		InteractiveCommandLine cli = new InteractiveCommandLine();
		cli.start();

	}

	public void testPersistUser() {
		UserImpl user = new UserImpl();
		user.setFirstName("Harry");
		user.setLastName("Trebing");
		user.setEmailAddress("hgmtrebing@outlook.com");
		user.setUsername("hgmtrebing");

		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction t = session.beginTransaction();
			session.persist(user);
			// t.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			log.warn("", e);
		}
	}
}
