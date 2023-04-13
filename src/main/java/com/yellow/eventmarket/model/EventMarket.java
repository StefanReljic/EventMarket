package com.yellow.eventmarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_market")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMarket {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EventMarketStatus status;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "market_id")
	private Market market;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "event_market_id")
	private List<EventMarketOutcome> outcomes;

}
