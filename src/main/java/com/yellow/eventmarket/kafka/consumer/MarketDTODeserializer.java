package com.yellow.eventmarket.kafka.consumer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.yellow.eventmarket.dto.MarketDTO;

public class MarketDTODeserializer extends JsonDeserializer<MarketDTO>{

}
