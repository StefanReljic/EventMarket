//package com.yellow.eventmarket.kafka;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
//import org.apache.kafka.streams.kstream.Consumed;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Produced;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.config.KafkaStreamsConfiguration;
//
//@Configuration
//@EnableKafkaStreams
//public class KafkaStreamsConfig {
//
//	@Value("${kafka.bootstrap-servers}")
//	private String bootstrapServers;
//
//	@Value("${kafka.consumer.group-id}")
//	private String consumerGroupId;
//
//	@Value("${kafka.topic.input}")
//	private String inputTopic;
//
//	@Value("${kafka.topic.output}")
//	private String outputTopic;
//
//	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//	public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-stream-processing-app");
//		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		props.put(StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
//				LogAndContinueExceptionHandler.class);
//		props.put(StreamsConfig.DEFAULT_PRODUCTION_EXCEPTION_HANDLER_CLASS_CONFIG,
//				LogAndContinueExceptionHandler.class);
//		props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 3);
//		return new KafkaStreamsConfiguration(props);
//	}
//
//	@Bean
//	public KStream<String, String> kafkaStream() {
//		StreamsBuilder builder = new StreamsBuilder();
//		KStream<String, String> input = builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));
//		KStream<String, String> output = input.mapValues(v -> "Processed " + v);
//		output.to(outputTopic, Produced.with(Serdes.String(), Serdes.String()));
//		return input;
//	}
//
//	@Bean
//	public KafkaStreams kafkaStreams() {
//		return new KafkaStreams(kafkaStream().build(), kafkaStreamsConfiguration().asProperties());
//	}
//}
