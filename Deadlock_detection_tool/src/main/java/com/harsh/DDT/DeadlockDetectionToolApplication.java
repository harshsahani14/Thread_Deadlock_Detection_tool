package com.harsh.DDT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DeadlockDetectionToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeadlockDetectionToolApplication.class, args);
	}

}
