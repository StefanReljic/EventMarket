package com.yellow.eventmarket.dto;

import java.util.List;

import com.yellow.eventmarket.enums.MarketStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketDTO {

	private String id;
	private String name;
	private MarketStatus status;
	private List<MarketOutcomeDTO> marketOutcomes;

}
