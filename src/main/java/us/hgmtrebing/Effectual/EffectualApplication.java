package us.hgmtrebing.Effectual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EffectualApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EffectualApplication.class);

	public static void main(String[] args) {
		log.info("Initializing Effectual Application.");
		SpringApplication.run(EffectualApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Beginning Command Line Runner ...");

	}
}
