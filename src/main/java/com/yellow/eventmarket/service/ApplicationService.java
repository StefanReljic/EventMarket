package com.yellow.eventmarket.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.configuration.StateHolder;
import com.yellow.eventmarket.model.ApplicationState;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.repository.MarketRepository;

@Service
public class ApplicationService {

	@Autowired
	private MarketRepository marketRepository;
	@Autowired
	private StateHolder stateHolder;

	public void loadInitialState() {
		System.out.println("ucitavam state");
		List<Market> markets = StreamSupport.stream(marketRepository.findAll().spliterator(), false).toList();
		stateHolder.setState(new ApplicationState(markets));
	}

	public void handleMarketUpdate(Market market) {
		stateHolder.getState().getMarkets().removeIf(existingMarket -> existingMarket.getId().equals(market.getId()));
		stateHolder.getState().getMarkets().add(market);
	}
}
