package com.yellow.eventmarket.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.kafka.consumer.MarketDTODeserializer;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamsConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${spring.kafka.consumer.group-id}")
	private String consumerGroupId;

	@Value("${kafka.topic.market}")
	private String marketTopic;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
		Map<String, Object> props = new HashMap<>();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-stream-processing-app");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		return new KafkaStreamsConfiguration(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MarketDTO> marketKafkaListenerContainerFactory() {
		return new CustomKafkaListenerContainerFactory<MarketDTO>("marketFactory", MarketDTODeserializer.class);
	}

//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, String> eventKafkaListenerContainerFactory() {
//		return new CustomKafkaListenerContainerFactory<MarketDTO>("eventFactory", MarketDTODeserializer.class);
//	}

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 15000000);
		return props;
	}

	@Bean
	public ProducerFactory<String, MarketDTO> marketProducerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<String, MarketDTO> marketKafkaTemplate() {
		return new KafkaTemplate<>(marketProducerFactory());
	}
}
