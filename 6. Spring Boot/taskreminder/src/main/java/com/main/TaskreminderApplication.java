package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TaskreminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskreminderApplication.class, args);
	}

}
