package us.hgmtrebing.Effectual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.hgmtrebing.Effectual.database.DatabaseService;
import us.hgmtrebing.Effectual.impl.User;

@SpringBootApplication
public class EffectualApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EffectualApplication.class);

	@Autowired
	private DatabaseService databaseService;

	public static void main(String[] args) {
		log.info("Initializing Effectual Application.");
		SpringApplication.run(EffectualApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testPersistUser();
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

		this.databaseService.persistObject(user);
		this.databaseService.persistObject(user1);
	}
}
