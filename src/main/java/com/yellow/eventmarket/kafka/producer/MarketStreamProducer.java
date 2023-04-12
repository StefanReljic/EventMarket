package com.yellow.eventmarket.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.model.Market;

@Service
public class MarketStreamProducer {

	@Autowired
	private KafkaTemplate<String, Market> kafkaTemplate;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	public void sendMarketToStream(Market market) {
		kafkaTemplate.send(marketTopic, market.getId(), market);
	}

}
