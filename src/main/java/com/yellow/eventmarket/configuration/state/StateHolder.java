package com.yellow.eventmarket.configuration.state;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.ApplicationState;
import com.yellow.eventmarket.model.Event;

import lombok.Data;

@Data
@Component
public class StateHolder {

	private ApplicationState state;

	public void removeStartedEvents() {
		List<Event> eventsToRemove = state.getEvents().stream().filter(Event::isActive).toList();
		state.getEvents().removeAll(eventsToRemove);
	}

}
