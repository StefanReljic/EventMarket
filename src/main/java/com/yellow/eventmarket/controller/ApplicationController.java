package com.yellow.eventmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.ApplicationStateDTO;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.dto.mapper.EventMapper;
import com.yellow.eventmarket.dto.mapper.MarketMapper;

@RestController
public class ApplicationController {

	@Autowired
	private StateHolder stateHolder;
	@Autowired
	private MarketMapper marketMapper;
	@Autowired
	private EventMapper eventMapper;

	@GetMapping("/data")
	public ApplicationStateDTO getData() {
		List<EventDTO> events = stateHolder.getState().getEvents().stream().map(eventMapper::mapToEventDTO).toList();
		List<MarketDTO> markets = stateHolder.getState().getMarkets().stream().map(marketMapper::mapToMarketDTO)
				.toList();
		return new ApplicationStateDTO(markets, events);
	}

}
