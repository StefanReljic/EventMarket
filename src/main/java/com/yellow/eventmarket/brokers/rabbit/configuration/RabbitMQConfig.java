package com.yellow.eventmarket.brokers.rabbit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yellow.eventmarket.brokers.MessageProducer;
import com.yellow.eventmarket.brokers.rabbit.producer.EventQueueProducer;
import com.yellow.eventmarket.brokers.rabbit.producer.MarketQueueProducer;
import com.yellow.eventmarket.dto.EventDTO;
import com.yellow.eventmarket.dto.MarketDTO;

@Configuration
@Profile("rabbitmq")
public class RabbitMQConfig {

//    @Bean
//    public ConnectionFactory rabbitConnectionFactory() {
//        // ...
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        // ...
//    }
//
//    // RabbitMQ consumer configuration
//
//    @Bean
//    public SimpleMessageListenerContainer rabbitListenerContainer() {
//        // ...
//    }

	@Bean(name = "eventProducer")
	public MessageProducer<EventDTO> eventMessageProducer() {
		return new EventQueueProducer();
	}

	@Bean(name = "marketProducer")
	public MessageProducer<MarketDTO> marketMessageProducer() {
		return new MarketQueueProducer();
	}
}