package com.yellow.eventmarket.brokers;

public interface MessageProducer<T> {

	public void sendMessage(T message);

}
