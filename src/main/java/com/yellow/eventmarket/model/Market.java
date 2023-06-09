package com.yellow.eventmarket.model;

import java.util.List;

import com.yellow.eventmarket.enums.MarketStatus;

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
@Table(name = "MARKET")
@NoArgsConstructor
@Data
public class Market {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private MarketStatus status;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "market_id")
	private List<MarketOutcome> outcomes;

}
