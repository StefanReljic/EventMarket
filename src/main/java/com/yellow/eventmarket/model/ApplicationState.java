package com.yellow.eventmarket.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationState {

	private List<Market> markets;

}
