package com.yellow.eventmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yellow.eventmarket.enums.EventMarketOutcomeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_market_outcome")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMarketOutcome {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EventMarketOutcomeStatus status;

	private double odd;

	@ManyToOne
	@JoinColumn(name = "market_outcome_id")
	private MarketOutcome outcome;

}
