package com.yellow.eventmarket.dto.mapper;

import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.EventMarketOutcomeDTO;
import com.yellow.eventmarket.model.EventMarketOutcome;

@Component
public class EventMarketOutcomeMapper {

	public EventMarketOutcomeDTO mapToEventMarketOutcomeDTO(EventMarketOutcome eventMarketOutcome) {
		EventMarketOutcomeDTO eventMarketOutcomeDTO = new EventMarketOutcomeDTO();
		eventMarketOutcomeDTO.setId(eventMarketOutcome.getId());
		eventMarketOutcomeDTO.setStatus(eventMarketOutcome.getStatus().getCode());
		eventMarketOutcomeDTO.setOutcomeId(eventMarketOutcome.getOutcome().getId());
		eventMarketOutcomeDTO.setOdds(eventMarketOutcome.getOdd());
		return eventMarketOutcomeDTO;
	}

}
