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
import com.yellow.eventmarket.dto.EventDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

	@Qualifier("eventProducer")
	@Autowired
	private MessageProducer<EventDTO> eventStreamProducer;

	@PostMapping
	public ResponseEntity<?> createEvent(@RequestBody @Valid EventDTO eventDTO) {
		eventStreamProducer.sendMessage(eventDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<?> updateEvent(@RequestBody @Valid EventDTO eventDTO) {
		eventStreamProducer.sendMessage(eventDTO);
		return ResponseEntity.ok().build();
	}

}
