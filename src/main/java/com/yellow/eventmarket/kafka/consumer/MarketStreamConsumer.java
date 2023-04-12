package com.yellow.eventmarket.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.service.MarketService;

@Component
public class MarketStreamConsumer {

	@Autowired
	private MarketService marketService;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Value("${kafka.group.market}")
	private String marketGroup;

	@KafkaListener(topics = "${kafka.topic.market}", groupId = "${kafka.group.market}", containerFactory = "marketKafkaListenerContainerFactory")
	public void listenGroupLongMessage(Market market) {

	}

}
