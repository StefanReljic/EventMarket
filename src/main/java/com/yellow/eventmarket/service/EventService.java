package com.yellow.eventmarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.EventMarketDTO;
import com.yellow.eventmarket.dto.EventMarketOutcomeDTO;
import com.yellow.eventmarket.model.Event;
import com.yellow.eventmarket.model.EventMarket;
import com.yellow.eventmarket.model.EventMarketOutcome;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.model.MarketOutcome;

@Service
public class EventService {

	@Autowired
	private StateHolder stateHolder;
	@Autowired
	private ModelMapper modelMapper;

	public void handleEventUpdate(EventDTO eventDTO) {
		Optional<Event> eventFromState = stateHolder.getState().getEvents().stream()
				.filter(existingEvent -> existingEvent.getId().equals(eventDTO.getId())).findFirst();
		if (eventFromState.isEmpty()) {
			stateHolder.getState().getEvents().add(createEvent(eventDTO));
		} else {
			updateEvent(eventDTO, eventFromState.get());
		}
	}

	private void updateEvent(EventDTO eventDTO, Event event) {
		if (eventDTO.getName() != null) {
			event.setName(eventDTO.getName());
		}
		if (eventDTO.getStartsAt() != null) {
			event.setStartsAt(eventDTO.getStartsAt());
		}
		if (eventDTO.getStatus() != null) {
			event.setStatus(eventDTO.getStatus());
		}
	}

	private Event createEvent(EventDTO eventDTO) {
		List<EventMarket> eventMarkets = createEventMarkets(eventDTO);
		Event event = modelMapper.map(eventDTO, Event.class);
		event.setMarkets(eventMarkets);
		return event;
	}

	private List<EventMarket> createEventMarkets(EventDTO eventDTO) {
		return eventDTO.getMarkets().stream().map(this::createEventMarket).collect(Collectors.toList());
	}

	private EventMarket createEventMarket(EventMarketDTO eventMarketDTO) {
		Market market = findMarketById(eventMarketDTO.getMarketId());
		List<EventMarketOutcome> outcomes = createEventMarketOutcomes(market, eventMarketDTO.getOutcomes());
		EventMarket eventMarket = modelMapper.map(eventMarketDTO, EventMarket.class);
		eventMarket.setMarket(market);
		eventMarket.setOutcomes(outcomes);
		return eventMarket;
	}

	private Market findMarketById(String marketId) {
		return this.stateHolder.getState().getMarkets().stream().filter(m -> m.getId().equals(marketId)).findFirst()
				.orElseThrow();
	}

	private List<EventMarketOutcome> createEventMarketOutcomes(Market market, List<EventMarketOutcomeDTO> outcomes) {
		return outcomes.stream().map(outcome -> createEventMarketOutcome(market, outcome)).collect(Collectors.toList());
	}

	private EventMarketOutcome createEventMarketOutcome(Market market, EventMarketOutcomeDTO eventMarketOutcomeDTO) {
		MarketOutcome marketOutcome = market.getOutcomes().stream()
				.filter(outcome -> outcome.getId().equals(eventMarketOutcomeDTO.getOutcomeId())).findFirst()
				.orElseThrow(() -> new RuntimeException("No MarketOutcome with id "
						+ eventMarketOutcomeDTO.getOutcomeId() + " for Market with id " + market.getId()));
		EventMarketOutcome eventMarketOutcome = modelMapper.map(eventMarketOutcomeDTO, EventMarketOutcome.class);
		eventMarketOutcome.setOutcome(marketOutcome);
		eventMarketOutcome.setOdd(eventMarketOutcomeDTO.getOdds());
		return eventMarketOutcome;
	}

}
