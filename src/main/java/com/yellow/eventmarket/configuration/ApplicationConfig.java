package com.yellow.eventmarket.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@Profile("database")
	public InitialStateLoader databaseLoader() {
		return new DatabaseLoader();
	}

	@Bean
	@Profile("filesystem")
	public InitialStateLoader fileLoader() {
		return new FileLoader();
	}

}
