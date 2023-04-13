package com.yellow.eventmarket.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.EventMarketDTO;
import com.yellow.eventmarket.dto.EventMarketOutcomeDTO;
import com.yellow.eventmarket.model.EventMarket;

@Component
public class EventMarketMapper {

	@Autowired
	private EventMarketOutcomeMapper eventMarketOutcomeMapper;

	public EventMarketDTO mapToEventMarketDTO(EventMarket eventMarket) {
		List<EventMarketOutcomeDTO> eventMarketOutcomes = eventMarket.getOutcomes().stream()
				.map(eventMarketOutcomeMapper::mapToEventMarketOutcomeDTO).toList();
		EventMarketDTO eventMarketDTO = new EventMarketDTO();
		eventMarketDTO.setId(eventMarket.getId());
		eventMarketDTO.setStatus(eventMarket.getStatus().getCode());
		eventMarketDTO.setMarketId(eventMarket.getMarket().getId());
		eventMarketDTO.setOutcomes(eventMarketOutcomes);
		return eventMarketDTO;
	}

}
