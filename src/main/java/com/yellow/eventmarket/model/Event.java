package com.yellow.eventmarket.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.eventmarket.enums.EventStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EVENT")
@Data
@NoArgsConstructor
public class Event {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(name = "starts_at", nullable = false)
	private LocalDateTime startsAt;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EventStatus status;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private List<EventMarket> markets;

	public boolean isActive() {
		return EventStatus.ACTIVE.equals(status);
	}

}
