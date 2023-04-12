package com.yellow.eventmarket.configuration;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yellow.eventmarket.model.ApplicationState;
import com.yellow.eventmarket.model.Market;

public class FileLoader implements InitialStateLoader {

	@Value("classpath:initialState.json")
	private Resource resourceFile;

	@Override
	public ApplicationState loadInitialState() {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Market>> typeReference = new TypeReference<>() {
		};
		List<Market> markets = null;
		try {
			markets = objectMapper.readValue(resourceFile.getInputStream(), typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ApplicationState(markets, null);
	}

}
