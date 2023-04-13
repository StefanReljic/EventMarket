package com.yellow.eventmarket.configuration.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.ApplicationState;

@Component
public class StateInitializer {

	@Autowired
	private InitialStateLoader initialStateLoader;
	@Autowired
	private StateHolder stateHolder;

	public void initializeState() {
		ApplicationState state = initialStateLoader.loadInitialState();
		stateHolder.setState(state);
	}

}
