package com.yellow.eventmarket.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor
public class Event {

//	@Id
//	@Column(unique = true, updatable = false)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long rowId;

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(name = "starts_at", nullable = false)
	private LocalDateTime startsAt;

	@ManyToOne
	@JoinColumn(name = "event_status_id")
	private EventStatus status;

	@OneToMany
	@JoinColumn(name = "event_market_id")
	private List<EventMarket> markets;
}
