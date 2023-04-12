package com.yellow.eventmarket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.ApplicationState;

@Component
public class ApplicationInitializer implements ApplicationRunner {

	@Autowired
	private InitialStateLoader initialStateLoader;
	@Autowired
	private StateHolder stateHolder;

	@Override
	public void run(ApplicationArguments args) {
		System.err.println(initialStateLoader.getClass());
		ApplicationState state = initialStateLoader.loadInitialState();
		stateHolder.setState(state);
	}

}
