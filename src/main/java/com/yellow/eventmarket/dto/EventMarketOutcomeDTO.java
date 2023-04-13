package com.yellow.eventmarket.dto;

import com.yellow.eventmarket.enums.EventMarketOutcomeStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EventMarketOutcomeDTO {

	private String id;

	@Enumerated(EnumType.STRING)
	private EventMarketOutcomeStatus status;

	private double odds;

	private String outcomeId;

}
