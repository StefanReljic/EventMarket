package com.yellow.eventmarket.model;

import java.time.LocalDateTime;
import java.util.List;

import com.yellow.eventmarket.enums.EventStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor
public class Event {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(name = "starts_at", nullable = false)
	private LocalDateTime startsAt;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EventStatus status;

	@OneToMany
	@JoinColumn(name = "event_market_id")
	private List<EventMarket> markets;
}
