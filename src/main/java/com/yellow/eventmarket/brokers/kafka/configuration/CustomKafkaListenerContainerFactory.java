package com.yellow.eventmarket.brokers.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Profile("kafka")
public class CustomKafkaListenerContainerFactory<T> extends ConcurrentKafkaListenerContainerFactory<String, T> {

	public CustomKafkaListenerContainerFactory(String bootstrapServer, String groupId,
			Class<? extends JsonDeserializer<T>> valueDeserializer) {
		super();

		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
		props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20971520");
		props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "20971520");

		this.setConsumerFactory(new DefaultKafkaConsumerFactory<>(props));
	}

}
