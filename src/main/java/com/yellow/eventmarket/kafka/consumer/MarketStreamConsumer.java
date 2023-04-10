package com.yellow.eventmarket.kafka.consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.service.MarketService;

@Component
public class MarketStreamConsumer {

	@Autowired
	private MarketService marketService;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Value("${kafka.group.market}")
	private String marketGroup;

	@StreamListener(value = "${kafka.topic.market}")
	public void processOfferMessage(KStream<String, MarketDTO> offerStream) {
		System.out.println("konzumiram kafku");
		// Consume messages from the "create-offer-topic" topic
		offerStream.foreach((key, value) -> {
			// Process the message
			marketService.createMarket(value);
		});
	}

}
