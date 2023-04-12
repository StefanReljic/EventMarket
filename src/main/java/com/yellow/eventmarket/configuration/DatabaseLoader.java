package com.yellow.eventmarket.configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.yellow.eventmarket.model.ApplicationState;
import com.yellow.eventmarket.model.Event;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.repository.EventRepository;
import com.yellow.eventmarket.repository.MarketRepository;

public class DatabaseLoader implements InitialStateLoader {

	@Autowired
	private MarketRepository marketRepository;
	@Autowired
	private EventRepository eventRepository;

	@Override
	public ApplicationState loadInitialState() {
		List<Market> markets = StreamSupport.stream(marketRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		List<Event> events = StreamSupport.stream(eventRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return new ApplicationState(markets, events);
	}

}
