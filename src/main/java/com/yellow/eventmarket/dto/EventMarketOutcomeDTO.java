package com.yellow.eventmarket.dto;

import com.yellow.eventmarket.enums.EventMarketOutcomeStatus;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventMarketOutcomeDTO {

	@NotEmpty(message = "Id cannot be empty")
	private String id;
	@NotNull(message = "Status must exist")
	private EventMarketOutcomeStatus status;
	private double odds;
	@NotEmpty(message = "Outcome id cannot be empty")
	private String outcomeId;

}
