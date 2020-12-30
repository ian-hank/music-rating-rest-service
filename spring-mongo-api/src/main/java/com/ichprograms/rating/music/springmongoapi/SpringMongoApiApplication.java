package com.ichprograms.rating.music.springmongoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.ichprograms.rating.music")
@EnableMongoRepositories
public class SpringMongoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApiApplication.class, args);
	}

}
