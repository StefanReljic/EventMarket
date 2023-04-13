package com.yellow.eventmarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.ApplicationStateDTO;

@RestController
public class ApplicationController {

	@GetMapping("/data")
	public ApplicationStateDTO getData() {

		return null;
	}

}
