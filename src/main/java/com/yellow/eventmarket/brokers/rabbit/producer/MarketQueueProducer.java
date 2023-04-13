package com.yellow.eventmarket.brokers.rabbit.producer;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.dto.MarketDTO;

public class MarketQueueProducer implements MessageProducer<MarketDTO> {

	@Override
	public void sendMessage(MarketDTO message) {
		throw new UnsupportedOperationException("Method not implemented");
	}

}
