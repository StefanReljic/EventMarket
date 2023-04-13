package com.yellow.eventmarket.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationState {

	private List<Market> markets = new ArrayList<>();
	private List<Event> events = new ArrayList<>();

}
