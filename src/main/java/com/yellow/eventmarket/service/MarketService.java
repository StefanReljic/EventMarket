package com.yellow.eventmarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.model.MarketOutcome;

@Service
public class MarketService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StateHolder stateHolder;

	public void handleMarketUpdate(MarketDTO marketDTO) {
		stateHolder.getState().getMarkets()
				.removeIf(existingMarket -> existingMarket.getId().equals(marketDTO.getId()));
		stateHolder.getState().getMarkets().add(createMarket(marketDTO));
	}

	private Market createMarket(MarketDTO marketDTO) {
		List<MarketOutcome> outcomes = marketDTO.getOutcomes().stream()
				.map(outcome -> modelMapper.map(outcome, MarketOutcome.class)).collect(Collectors.toList());
		Market market = modelMapper.map(marketDTO, Market.class);
		market.setOutcomes(outcomes);
		return market;
	}

}
