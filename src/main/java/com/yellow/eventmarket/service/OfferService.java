package com.yellow.eventmarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.ApplicationStateDTO;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.EventMarketDTO;
import com.yellow.eventmarket.dto.EventMarketOutcomeDTO;
import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.dto.mapper.EventMapper;
import com.yellow.eventmarket.dto.mapper.MarketMapper;

@Service
public class OfferService {

	@Autowired
	private StateHolder stateHolder;
	@Autowired
	private MarketMapper marketMapper;
	@Autowired
	private EventMapper eventMapper;

	public ApplicationStateDTO getOffer() {
		List<EventDTO> events = stateHolder.getState().getEvents().stream().map(eventMapper::mapToEventDTO).toList();
		Map<String, List<String>> usedMarkets = getUsedMarketsAndOutcomes(events);
		List<MarketDTO> markets = filterMarketsAndMarketOutcomes(usedMarkets);
		cleanMarketOutcomesFromEvents(events);
		return new ApplicationStateDTO(markets, events);
	}

	private void cleanMarketOutcomesFromEvents(List<EventDTO> events) {
		events.forEach(event -> event.getMarkets().forEach(market -> market.setOutcomes(null)));
	}

	private Map<String, List<String>> getUsedMarketsAndOutcomes(List<EventDTO> eventDTOs) {
		Map<String, List<String>> result = new HashMap<>();
		for (EventDTO eventDTO : eventDTOs) {
			for (EventMarketDTO eventMarketDTO : eventDTO.getMarkets()) {
				List<String> usedOutcomes = eventMarketDTO.getOutcomes().stream()
						.map(EventMarketOutcomeDTO::getOutcomeId).collect(Collectors.toList());
				if (result.containsKey(eventMarketDTO.getMarketId())) {
					List<String> existingIds = result.get(eventMarketDTO.getMarketId());
					existingIds.addAll(usedOutcomes);
					result.put(eventMarketDTO.getMarketId(), existingIds);
				} else {
					result.put(eventMarketDTO.getMarketId(), usedOutcomes);
				}
			}
		}
		return result;
	}

	private List<MarketDTO> filterMarketsAndMarketOutcomes(Map<String, List<String>> usedMarkets) {
		return stateHolder.getState().getMarkets().stream().map(marketMapper::mapToMarketDTO)
				.filter(market -> usedMarkets.containsKey(market.getId()))
				.peek(market -> market.setOutcomes(market.getOutcomes().stream()
						.filter(outcome -> usedMarkets.get(market.getId()).contains(outcome.getId()))
						.collect(Collectors.toList())))
				.toList();
	}

}
