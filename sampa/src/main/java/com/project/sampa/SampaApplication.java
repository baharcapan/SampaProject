package com.project.sampa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.project.sampa.service","com.project.sampa.controller","com.project.sampa","com.project.sampa.dto.mapper"})
@EntityScan("com.project.sampa.model")
public class SampaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampaApplication.class, args);
	}

}
