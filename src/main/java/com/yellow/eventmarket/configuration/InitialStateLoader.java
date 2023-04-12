package com.yellow.eventmarket.configuration;

import com.yellow.eventmarket.model.ApplicationState;

public interface InitialStateLoader {

	public ApplicationState loadInitialState();

}
