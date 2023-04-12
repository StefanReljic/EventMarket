package com.yellow.eventmarket.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.kafka.producer.MarketStreamProducer;
import com.yellow.eventmarket.model.Market;

@RestController
@RequestMapping("/markets")
public class MarketController {

	@Autowired
	private MarketStreamProducer marketStreamProducer;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<?> createMarket(@RequestBody MarketDTO marketDTO) {
		Market market = modelMapper.map(marketDTO, Market.class);
		System.out.println(market.getId());
		System.out.println(market.getName());
//		marketStreamProducer.sendMarketToStream(market);
		return ResponseEntity.ok().build();
	}

}
