package com.yellow.eventmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.MarketRepository;
import com.yellow.eventmarket.model.Market;

@Service
public class MarketService {

	@Autowired
	private MarketRepository marketRepository;

	public void createOrUpdateMarket(Market value) {

	}

}
