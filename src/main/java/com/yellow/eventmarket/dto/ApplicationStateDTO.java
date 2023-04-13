package com.yellow.eventmarket.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationStateDTO {

	private List<MarketDTO> markets;
	private List<EventDTO> events;

}
