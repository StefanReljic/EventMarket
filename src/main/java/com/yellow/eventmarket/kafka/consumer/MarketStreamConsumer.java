package com.yellow.eventmarket.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.service.MarketService;

@Component
public class MarketStreamConsumer {

	@Autowired
	private MarketService marketService;

	@KafkaListener(topics = "${kafka.topic.market}", groupId = "${kafka.group.market}", containerFactory = "marketKafkaListenerContainerFactory")
	public void listenMarketMessage(Market market) {
		marketService.handleMarketUpdate(market);
	}

}
