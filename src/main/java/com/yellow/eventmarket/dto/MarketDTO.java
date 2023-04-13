package com.yellow.eventmarket.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarketDTO implements Serializable {

	private static final long serialVersionUID = -3811732657120882496L;

	@NotBlank(message = "Id cannot be empty")
	private String id;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@NotNull(message = "Status cannot be null")
	private Integer status;
	@Valid
	private List<MarketOutcomeDTO> outcomes;

}