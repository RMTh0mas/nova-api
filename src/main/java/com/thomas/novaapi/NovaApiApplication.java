package com.thomas.novaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaApiApplication.class, args);
		System.out.println("Nova api...");
		System.out.println("Alteração da branch developer");
	}

}
