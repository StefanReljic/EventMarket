package com.yellow.eventmarket.kafka.consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.service.MarketService;

public class MarketStreamConsumer {

	@Autowired
	private MarketService marketService;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Value("${kafka.group.market}")
	private String marketGroup;

	@StreamListener(target = "market-topic")
	public void processOfferMessage(@Input("market-topic") KStream<String, Market> offerStream) {
		System.out.println("konzumiram kafku");
		// Consume messages from the "create-offer-topic" topic
		offerStream.foreach((key, value) -> {
			// Process the message
			marketService.createMarket(value);
		});
	}

}
