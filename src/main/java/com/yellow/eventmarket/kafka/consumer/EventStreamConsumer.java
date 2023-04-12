package com.yellow.eventmarket.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.Event;
import com.yellow.eventmarket.service.EventService;

@Component
public class EventStreamConsumer {

	@Autowired
	private EventService eventService;

	@KafkaListener(topics = "${kafka.topic.event}", groupId = "${kafka.group.event}", containerFactory = "eventKafkaListenerContainerFactory")
	public void listenEventMessage(Event event) {
		eventService.handleEventUpdate(event);
	}

}
