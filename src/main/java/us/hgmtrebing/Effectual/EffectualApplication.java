package us.hgmtrebing.Effectual;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.hgmtrebing.Effectual.cli.InteractiveCommandLine;
import us.hgmtrebing.Effectual.database.HibernateInterface;
import us.hgmtrebing.Effectual.database.UserService;
import us.hgmtrebing.Effectual.impl.Project;
import us.hgmtrebing.Effectual.impl.User;

@SpringBootApplication
public class EffectualApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EffectualApplication.class);

	@Autowired
	private HibernateInterface hibernateInterface;

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
		User user = new User();
		user.setFirstName("Harry");
		user.setLastName("Trebing");
		user.setEmailAddress("hgmtrebing@outlook.com");
		user.setUsername("hgmtrebing");

		User user1 = new User();
		user1.setFirstName("Anjanette");
		user1.setLastName("Trebing");
		user1.setEmailAddress("aktrebing@outlook.com");
		user1.setUsername("aktrebing");

		Project project = new Project();
		project.setAuthor(user);
		project.setName("Test Project Name");
		project.setDescription("Test Project Description");

		Project project1 = new Project();
		project1.setAuthor(user);
		project1.setName("Harry's Project");
		project1.setDescription("Personal Project");

		this.hibernateInterface.persistObject(user);
		this.hibernateInterface.persistObject(project);
		this.hibernateInterface.persistObject(user1);
		this.hibernateInterface.persistObject(project1);
	}
}
