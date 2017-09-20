package com.example.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.models", "com.example.service","com.example.info"})
public class Restapi1Application {

	public static void main(String[] args) {
		SpringApplication.run(Restapi1Application.class, args);
	}
}
