package com.example.catsAndOwners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatsAndOwnersApplication implements CommandLineRunner {

	@Autowired
	Owner o;

	@Autowired
	Cat c;

	public static void main(String[] args) {
		SpringApplication.run(CatsAndOwnersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		o.introduction();
	}
}
