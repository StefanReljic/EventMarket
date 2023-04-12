package com.yellow.eventmarket.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "market")
@Getter
@NoArgsConstructor
public class MarketDTO {

	private String id;
	private String name;

}
