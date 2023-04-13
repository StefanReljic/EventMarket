package com.yellow.eventmarket.dto;

import java.io.Serializable;

import com.yellow.eventmarket.enums.MarketOutcomeStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketOutcomeDTO implements Serializable {

	private static final long serialVersionUID = 2617102111304970896L;

	@NotBlank(message = "Id cannot be empty")
	private String id;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@NotNull(message = "Status cannot be null")
	private MarketOutcomeStatus status;

}
