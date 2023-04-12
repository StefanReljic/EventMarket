package com.yellow.eventmarket;

import org.springframework.data.repository.CrudRepository;

import com.yellow.eventmarket.model.Market;

public interface MarketRepository extends CrudRepository<Market, String> {

}
