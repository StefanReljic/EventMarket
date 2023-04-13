package com.yellow.eventmarket.dto;

import java.util.List;

import lombok.Data;

@Data
public class ApplicationStateDTO {

	public List<MarketDTO> markets;
	public List<EventDTO> events;

}
