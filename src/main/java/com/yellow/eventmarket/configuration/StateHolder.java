package com.yellow.eventmarket.configuration;

import org.springframework.stereotype.Component;

import com.yellow.eventmarket.model.ApplicationState;

import lombok.Data;

@Data
@Component
public class StateHolder {

	private ApplicationState state;

}
