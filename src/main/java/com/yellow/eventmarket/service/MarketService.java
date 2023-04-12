package com.yellow.eventmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.repository.MarketRepository;

@Service
public class MarketService {

	@Autowired
	private MarketRepository marketRepository;

	public void createOrUpdateMarket(Market value) {

	}

}
