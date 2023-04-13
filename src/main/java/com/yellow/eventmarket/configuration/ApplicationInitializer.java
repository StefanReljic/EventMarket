package com.yellow.eventmarket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.configuration.state.StateInitializer;

@Component
public class ApplicationInitializer implements ApplicationRunner {

	@Autowired
	private StateInitializer stateInitializer;

	@Override
	public void run(ApplicationArguments args) {
		stateInitializer.initializeState();
	}

}
