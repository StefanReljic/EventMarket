package com.yellow.eventmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.kafka.producer.MarketStreamProducer;

@RestController
@RequestMapping("/markets")
public class MarketController {

	@Autowired
	private MarketStreamProducer marketStreamProducer;

	@PostMapping
	public ResponseEntity<?> createMarket(@RequestBody MarketDTO marketDTO) {
		marketStreamProducer.sendMarketToStream(marketDTO);
		return ResponseEntity.ok().build();
	}

}
