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
@Table(name = "market")
@Getter
@NoArgsConstructor
public class Market {

	@Id
	@Column(name = "row_id", unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rowId;

	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "market_status_id")
	private MarketStatus status;

}
