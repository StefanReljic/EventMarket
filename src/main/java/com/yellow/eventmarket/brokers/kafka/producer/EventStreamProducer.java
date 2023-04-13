package com.yellow.eventmarket.brokers.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.dto.EventDTO;

@Profile("kafka")
@Service
public class EventStreamProducer implements MessageProducer<EventDTO> {

	@Autowired
	private KafkaTemplate<String, EventDTO> kafkaTemplate;

	@Value("${kafka.topic.event}")
	private String eventTopic;

	@Override
	public void sendMessage(EventDTO event) {
		kafkaTemplate.send(eventTopic, event.getId(), event);
	}

}
