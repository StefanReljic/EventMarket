package com.yellow.eventmarket.configuration.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StateCleanup {

	@Autowired
	private StateHolder stateHolder;

	@Scheduled(cron = "0 1 * * * * ?") // run every day at 1:00 AM
	public void cleanupStartedEvents() {
		stateHolder.removeStartedEvents();
	}
}
