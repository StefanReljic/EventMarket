package com.yellow.eventmarket.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.yellow.eventmarket.enums.EventStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EventDTO {

	private String id;
	private String name;
	private LocalDateTime startsAt;

	@Enumerated(EnumType.STRING)
	private EventStatus status;

	private List<EventMarketDTO> markets;

}
