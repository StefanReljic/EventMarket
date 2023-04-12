package com.yellow.eventmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.StateHolder;
import com.yellow.eventmarket.model.Event;

@Service
public class EventService {

	@Autowired
	private StateHolder stateHolder;

	public void handleEventUpdate(Event event) {
		stateHolder.getState().getEvents().removeIf(existingEvent -> existingEvent.getId().equals(event.getId()));
		stateHolder.getState().getEvents().add(event);
	}

}
