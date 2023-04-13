package com.yellow.eventmarket.dto;

import java.util.List;

import lombok.Data;

@Data
public class ApplicationStateDTO {

	private List<MarketDTO> markets;
	private List<EventDTO> events;

}
