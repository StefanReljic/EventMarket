package com.yellow.eventmarket.model;

import com.yellow.eventmarket.enums.MarketOutcomeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARKET_OUTCOME")
@Data
@NoArgsConstructor
public class MarketOutcome {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private MarketOutcomeStatus status;

}
