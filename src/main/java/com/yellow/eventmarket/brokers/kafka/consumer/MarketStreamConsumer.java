package com.yellow.eventmarket.brokers.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.brokers.MessageConsumer;
import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.service.MarketService;

@Profile("kafka")
@Component
public class MarketStreamConsumer implements MessageConsumer {

	@Autowired
	private MarketService marketService;

	@KafkaListener(topics = "${kafka.topic.market}", groupId = "${kafka.group.market}", containerFactory = "marketKafkaListenerContainerFactory")
	public void listenMarketMessage(MarketDTO marketDTO) {
		marketService.handleMarketUpdate(marketDTO);
	}

}
