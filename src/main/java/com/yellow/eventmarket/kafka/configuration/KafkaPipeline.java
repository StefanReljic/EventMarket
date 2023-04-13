package com.yellow.eventmarket.kafka.configuration;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaPipeline {

	private static final Serde<String> STRING_SERDE = Serdes.String();

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Value("${kafka.topic.event}")
	private String eventTopic;

	@Autowired
	void buildPipeline(StreamsBuilder streamsBuilder) {
		streamsBuilder.stream(marketTopic, Consumed.with(STRING_SERDE, STRING_SERDE));
		streamsBuilder.stream(eventTopic, Consumed.with(STRING_SERDE, STRING_SERDE));
	}

}