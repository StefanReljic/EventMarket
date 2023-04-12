package com.yellow.eventmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yellow.eventmarket.enums.MarketOutcomeStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "market_outcome")
@Getter
@NoArgsConstructor
public class MarketOutcome {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MarketOutcomeStatus status;

}
