package com.yellow.eventmarket.brokers.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.dto.MarketDTO;

@Profile("kafka")
@Service
public class MarketStreamProducer implements MessageProducer<MarketDTO> {

	@Autowired
	private KafkaTemplate<String, MarketDTO> kafkaTemplate;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Override
	public void sendMessage(MarketDTO marketDTO) {
		kafkaTemplate.send(marketTopic, marketDTO.getId(), marketDTO);
	}

}
