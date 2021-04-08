package com.mcforse.taskList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TaskListApplication {

	public static void main(String[] args) {
		String port = System.getenv("SERVER_PORT");
		if (port == null) {
			log.error("Environment variables not configured");
			return;
		}
		SpringApplication.run(TaskListApplication.class, args);
	}

}
