package com.yellow.eventmarket.configuration.state;

import com.yellow.eventmarket.model.ApplicationState;

public interface InitialStateLoader {

	public ApplicationState loadInitialState();

}
