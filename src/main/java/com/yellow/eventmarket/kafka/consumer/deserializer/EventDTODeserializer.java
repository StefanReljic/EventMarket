package com.yellow.eventmarket.kafka.consumer.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.yellow.eventmarket.dto.EventDTO;

public class EventDTODeserializer extends JsonDeserializer<EventDTO> {

}
