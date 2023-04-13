package com.yellow.eventmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.kafka.producer.EventStreamProducer;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventStreamProducer eventStreamProducer;

	@PostMapping
	public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) {
		eventStreamProducer.sendEventToStream(eventDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<?> updateEvent(@RequestBody EventDTO eventDTO) {
		eventStreamProducer.sendEventToStream(eventDTO);
		return ResponseEntity.ok().build();
	}

}
