package com.example.moduleclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClientApplcation {
	public static void main(String[] args) {
		SpringApplication.run(ClientApplcation.class, args);
	}
}
