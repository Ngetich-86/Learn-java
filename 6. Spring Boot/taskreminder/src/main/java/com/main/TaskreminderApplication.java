package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import io.github.cdimascio.dotenv.Dotenv;

@EnableCaching
@SpringBootApplication
public class TaskreminderApplication {

	public static void main(String[] args) {
		// Load .env file for local development
		Dotenv.configure().ignoreIfMissing().load();
		SpringApplication.run(TaskreminderApplication.class, args);
	}

}
