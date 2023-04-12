package com.yellow.eventmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.StateHolder;
import com.yellow.eventmarket.model.Market;

@Service
public class MarketService {

	@Autowired
	private StateHolder stateHolder;

	public void handleMarketUpdate(Market market) {
		stateHolder.getState().getMarkets().removeIf(existingMarket -> existingMarket.getId().equals(market.getId()));
		stateHolder.getState().getMarkets().add(market);
	}

}
