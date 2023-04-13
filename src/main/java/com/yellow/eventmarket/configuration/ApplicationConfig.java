package com.yellow.eventmarket.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yellow.eventmarket.configuration.state.DatabaseLoader;
import com.yellow.eventmarket.configuration.state.FileLoader;
import com.yellow.eventmarket.configuration.state.InitialStateLoader;

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
