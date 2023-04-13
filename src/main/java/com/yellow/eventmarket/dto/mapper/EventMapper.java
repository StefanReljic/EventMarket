package com.yellow.eventmarket.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.EventMarketDTO;
import com.yellow.eventmarket.model.Event;

@Component
public class EventMapper {

	@Autowired
	private EventMarketMapper eventMarketMapper;

	public EventDTO mapToEventDTO(Event event) {
		List<EventMarketDTO> eventMarkets = event.getMarkets().stream().map(eventMarketMapper::mapToEventMarketDTO)
				.toList();
		EventDTO eventDTO = new EventDTO();
		eventDTO.setId(event.getId());
		eventDTO.setName(event.getName());
		eventDTO.setStartsAt(event.getStartsAt());
		eventDTO.setStatus(event.getStatus().getCode());
		eventDTO.setMarkets(eventMarkets);
		return eventDTO;
	}

}
