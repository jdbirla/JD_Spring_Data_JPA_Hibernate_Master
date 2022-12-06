package com.jd.spring.data.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("com.jd.spring.data.mongo.repository")
@ComponentScan("com.jd.spring.*")
public class SpringDataMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoApplication.class, args);
	}

}
