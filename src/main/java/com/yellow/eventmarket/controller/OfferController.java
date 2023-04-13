package com.yellow.eventmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.ApplicationStateDTO;
import com.yellow.eventmarket.service.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@GetMapping
	public ApplicationStateDTO getOffer() {
		return offerService.getOffer();
	}

}
