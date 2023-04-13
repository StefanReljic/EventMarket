package com.yellow.eventmarket.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventMarketDTO {

	@NotEmpty(message = "Id cannot be empty")
	private String id;
	@NotNull(message = "Status must exist")
	private Integer status;
	@NotEmpty(message = "Market id cannot be emptu")
	private String marketId;
	@Valid
	private List<EventMarketOutcomeDTO> outcomes;

}
