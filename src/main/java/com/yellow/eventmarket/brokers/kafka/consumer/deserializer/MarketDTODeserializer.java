package com.yellow.eventmarket.brokers.kafka.consumer.deserializer;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.yellow.eventmarket.dto.MarketDTO;

@Profile("kafka")
public class MarketDTODeserializer extends JsonDeserializer<MarketDTO> {

}
