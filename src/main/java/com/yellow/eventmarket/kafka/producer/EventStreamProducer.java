package com.yellow.eventmarket.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.dto.EventDTO;

@Service
public class EventStreamProducer {

	@Autowired
	private KafkaTemplate<String, EventDTO> kafkaTemplate;

	@Value("${kafka.topic.event}")
	private String eventTopic;

	public void sendEventToStream(EventDTO event) {
		kafkaTemplate.send(eventTopic, event.getId(), event);
	}

}
