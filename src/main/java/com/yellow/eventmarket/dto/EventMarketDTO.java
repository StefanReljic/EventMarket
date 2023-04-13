package com.yellow.eventmarket.dto;

import java.util.List;

import com.yellow.eventmarket.enums.EventMarketStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EventMarketDTO {

	private String id;

	@Enumerated(EnumType.STRING)
	private EventMarketStatus status;

	private String marketId;
	private List<EventMarketOutcomeDTO> outcomes;

}
