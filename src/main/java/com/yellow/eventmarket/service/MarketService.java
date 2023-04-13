package com.yellow.eventmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.dto.mapper.MarketMapper;

@Service
public class MarketService {

	@Autowired
	private MarketMapper marketMapper;
	@Autowired
	private StateHolder stateHolder;

	public void handleMarketUpdate(MarketDTO marketDTO) {
		stateHolder.getState().getMarkets()
				.removeIf(existingMarket -> existingMarket.getId().equals(marketDTO.getId()));
		stateHolder.getState().getMarkets().add(marketMapper.mapToMarket(marketDTO));
	}

}
