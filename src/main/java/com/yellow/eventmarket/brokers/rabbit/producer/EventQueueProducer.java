package com.yellow.eventmarket.brokers.rabbit.producer;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.dto.EventDTO;

public class EventQueueProducer implements MessageProducer<EventDTO> {

	@Override
	public void sendMessage(EventDTO message) {
		throw new UnsupportedOperationException("Method not implemented");
	}

}
