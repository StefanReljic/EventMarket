package com.yellow.eventmarket.dto.mapper;

import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.MarketOutcomeDTO;
import com.yellow.eventmarket.enums.MarketOutcomeStatus;
import com.yellow.eventmarket.model.MarketOutcome;

@Component
public class MarketOutcomeMapper {

	public MarketOutcome mapToMarketOutcome(MarketOutcomeDTO outcome) {
		MarketOutcome marketOutcome = new MarketOutcome();
		marketOutcome.setId(outcome.getId());
		marketOutcome.setName(outcome.getId());
		marketOutcome.setStatus(MarketOutcomeStatus.fromCode(outcome.getStatus()));
		return marketOutcome;
	}

	public MarketOutcomeDTO mapToMarketOutcomeDTO(MarketOutcome marketOutcome) {
		MarketOutcomeDTO result = new MarketOutcomeDTO();
		result.setId(marketOutcome.getId());
		result.setName(marketOutcome.getName());
		result.setStatus(marketOutcome.getStatus().getCode());
		return result;
	}

}
