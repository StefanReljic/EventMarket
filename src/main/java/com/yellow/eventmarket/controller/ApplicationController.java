package com.yellow.eventmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.configuration.state.StateHolder;
import com.yellow.eventmarket.dto.ApplicationStateDTO;

@RestController
public class ApplicationController {

	@Autowired
	private StateHolder stateHolder; 
	
	@GetMapping("/data")
	public ApplicationStateDTO getData() {
//		stateHolder.getState().getEvents()
		return null;
	}

}
