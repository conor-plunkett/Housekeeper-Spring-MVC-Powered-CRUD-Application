package com.example.housekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		SpringApplication.run(CrudApplication.class, args);	// Tomcat port 8080
	}

}
