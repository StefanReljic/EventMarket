package com.yellow.eventmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_market")
@Getter
@NoArgsConstructor
public class EventMarket {

//	@Id
//	@Column(name = "row_id", unique = true, updatable = false)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long rowId;

	@Column(nullable = false, unique = true)
	private String id;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "market_id")
	private Market market;

	@ManyToOne
	@JoinColumn(name = "event_market_id")
	private EventMarketStatus status;

}
