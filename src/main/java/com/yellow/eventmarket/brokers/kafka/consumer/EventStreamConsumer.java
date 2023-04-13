package com.yellow.eventmarket.brokers.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.brokers.MessageConsumer;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.service.EventService;

@Profile("kafka")
@Component
public class EventStreamConsumer implements MessageConsumer {

	@Autowired
	private EventService eventService;

	@KafkaListener(topics = "${kafka.topic.event}", groupId = "${kafka.group.event}", containerFactory = "eventKafkaListenerContainerFactory")
	public void listenEventMessage(EventDTO eventDTO) {
		eventService.handleEventUpdate(eventDTO);
	}

}
