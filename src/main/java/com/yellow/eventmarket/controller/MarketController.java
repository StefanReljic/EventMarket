package com.yellow.eventmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.dto.MarketDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/markets")
public class MarketController {

	@Qualifier("marketProducer")
	@Autowired
	private MessageProducer<MarketDTO> eventProducer;

	@PostMapping
	public ResponseEntity<?> createMarket(@RequestBody @Valid MarketDTO marketDTO) {
		eventProducer.sendMessage(marketDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<?> updateMarket(@RequestBody @Valid MarketDTO marketDTO) {
		eventProducer.sendMessage(marketDTO);
		return ResponseEntity.ok().build();
	}

}
