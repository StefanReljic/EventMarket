package com.yellow.eventmarket.dto;

import com.yellow.eventmarket.enums.MarketOutcomeStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketOutcomeDTO {

	private String id;

	private String name;

	@Enumerated(EnumType.STRING)
	private MarketOutcomeStatus status;

}
