package com.yellow.eventmarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yellow.eventmarket.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

}
