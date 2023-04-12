package com.yellow.eventmarket.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.yellow.eventmarket.enums.MarketStatus;

import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "market")
@NoArgsConstructor
@Data
public class Market {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MarketStatus status;

	@OneToMany
	@JoinColumn(name = "market_outcome_id")
	private List<MarketOutcome> marketOutcomes;

}
