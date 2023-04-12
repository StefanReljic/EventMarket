package com.yellow.eventmarket.kafka;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordCountProcessor {

	private static final Serde<String> STRING_SERDE = Serdes.String();

	@Autowired
	void buildPipeline(StreamsBuilder streamsBuilder) {
		streamsBuilder.stream("market-topic", Consumed.with(STRING_SERDE, STRING_SERDE));
	}

}