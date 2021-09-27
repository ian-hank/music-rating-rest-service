package com.ichprograms.rating.music.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)				//Disables/Enables Spring Security
@ComponentScan("com.ichprograms.rating.music.api")
@EnableMongoRepositories
public class MusicRatingApplication {
	
	//Main Driver
	public static void main(String[] args) {
		SpringApplication.run(MusicRatingApplication.class, args);
	}
}