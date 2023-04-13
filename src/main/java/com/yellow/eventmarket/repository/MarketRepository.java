package com.yellow.eventmarket.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yellow.eventmarket.model.Market;

@Profile("database")
@Repository
public interface MarketRepository extends CrudRepository<Market, String> {

}
