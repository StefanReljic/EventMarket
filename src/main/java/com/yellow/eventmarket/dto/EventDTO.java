package com.yellow.eventmarket.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.yellow.eventmarket.enums.EventStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventDTO {

	@NotEmpty(message = "Id cannot be empty")
	private String id;
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	@NotNull(message = "Starts at must exist")
	private LocalDateTime startsAt;
	@NotNull(message = "Status must exist")
	private EventStatus status;
	@Valid
	private List<EventMarketDTO> markets;

}
