package com.yellow.eventmarket.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.yellow.eventmarket.model.Market;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "market")
@Getter
@NoArgsConstructor
public class MarketDTO implements ModelMapper<Market> {

	private String id;
	private String name;

	@Override
	public Market mapToModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
