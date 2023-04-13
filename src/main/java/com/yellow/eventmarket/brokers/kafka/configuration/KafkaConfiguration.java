package com.yellow.eventmarket.brokers.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.brokers.kafka.consumer.deserializer.EventDTODeserializer;
import com.yellow.eventmarket.brokers.kafka.consumer.deserializer.MarketDTODeserializer;
import com.yellow.eventmarket.brokers.kafka.producer.EventStreamProducer;
import com.yellow.eventmarket.brokers.kafka.producer.MarketStreamProducer;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.MarketDTO;

@Profile("kafka")
@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaConfiguration {

	private static final short EVENT_TOPIC_REPLICAS = (short) 1;
	private static final int EVENT_TOPIC_PARTITIONS = 2;

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${kafka.topic.event}")
	private String eventTopic;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
		Map<String, Object> props = new HashMap<>();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "event-market-app");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		return new KafkaStreamsConfiguration(props);
	}

	@Bean(name = "eventProducer")
	public MessageProducer<EventDTO> eventMessageProducer() {
		return new EventStreamProducer();
	}

	@Bean(name = "marketProducer")
	public MessageProducer<MarketDTO> marketMessageProducer() {
		return new MarketStreamProducer();
	}

	@Bean
	public NewTopic myTopic() {
		return new NewTopic(eventTopic, EVENT_TOPIC_PARTITIONS, EVENT_TOPIC_REPLICAS);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MarketDTO> marketKafkaListenerContainerFactory() {
		return new CustomKafkaListenerContainerFactory<>(bootstrapServers, "marketFactory",
				MarketDTODeserializer.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, EventDTO> eventKafkaListenerContainerFactory() {
		return new CustomKafkaListenerContainerFactory<>(bootstrapServers, "eventFactory", EventDTODeserializer.class);
	}

	@Bean
	public KafkaTemplate<String, MarketDTO> marketKafkaTemplate() {
		return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
	}

	@Bean
	public KafkaTemplate<String, EventDTO> eventKafkaTemplate() {
		return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
	}

	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 15000000);
		return props;
	}

}
