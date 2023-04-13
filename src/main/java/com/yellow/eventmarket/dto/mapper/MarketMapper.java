package com.yellow.eventmarket.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.dto.MarketOutcomeDTO;
import com.yellow.eventmarket.enums.MarketStatus;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.model.MarketOutcome;

@Component
public class MarketMapper {

	@Autowired
	private MarketOutcomeMapper marketOutcomeMapper;

	public Market mapToMarket(MarketDTO marketDTO) {
		List<MarketOutcome> outcomes = marketDTO.getOutcomes().stream().map(marketOutcomeMapper::mapToMarketOutcome)
				.collect(Collectors.toList());
		Market market = new Market();
		market.setId(marketDTO.getId());
		market.setName(marketDTO.getName());
		market.setStatus(MarketStatus.fromCode(marketDTO.getStatus()));
		market.setOutcomes(outcomes);
		return market;
	}

	public MarketDTO mapToMarketDTO(Market market) {
		List<MarketOutcomeDTO> outcomeDTOs = market.getOutcomes().stream()
				.map(marketOutcomeMapper::mapToMarketOutcomeDTO).toList();
		MarketDTO marketDTO = new MarketDTO();
		marketDTO.setId(market.getId());
		marketDTO.setName(market.getName());
		marketDTO.setStatus(market.getStatus().getCode());
		marketDTO.setOutcomes(outcomeDTOs);
		return marketDTO;
	}

}
