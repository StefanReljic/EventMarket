package com.yellow.eventmarket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.service.ApplicationService;

@Component
public class AppInitializer implements ApplicationRunner {

	@Autowired
	private ApplicationService applicationService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		applicationService.loadInitialState();
	}

}
