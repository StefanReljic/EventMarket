package com.yellow.eventmarket.dto;

import java.io.Serializable;
import java.util.List;

import com.yellow.eventmarket.enums.MarketStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarketDTO implements Serializable {

	private static final long serialVersionUID = -3811732657120882496L;

	private String id;
	private String name;
	private MarketStatus status;
	private List<MarketOutcomeDTO> outcomes;

}