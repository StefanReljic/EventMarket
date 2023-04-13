package com.yellow.eventmarket.dto;

import java.io.Serializable;

import com.yellow.eventmarket.enums.MarketOutcomeStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketOutcomeDTO implements Serializable {

	private static final long serialVersionUID = 2617102111304970896L;

	private String id;
	private String name;
	private MarketOutcomeStatus status;

}
