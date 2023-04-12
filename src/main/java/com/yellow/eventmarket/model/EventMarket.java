package com.yellow.eventmarket.model;

import java.util.List;

import com.yellow.eventmarket.enums.EventMarketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_market")
@Getter
@NoArgsConstructor
public class EventMarket {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EventMarketStatus status;

	@ManyToOne
	@JoinColumn(name = "market_id")
	private Market market;

	@OneToMany
	@JoinColumn(name = "event_market_id")
	private List<EventMarketOutcome> outcomes;

}
