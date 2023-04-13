package com.yellow.eventmarket.configuration.state;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yellow.eventmarket.exception.InitialStateLoadingException;
import com.yellow.eventmarket.model.ApplicationState;
import com.yellow.eventmarket.model.EventMarket;
import com.yellow.eventmarket.model.EventMarketOutcome;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.model.MarketOutcome;

public class FileLoader implements InitialStateLoader {

	@Value("classpath:initialState.json")
	private Resource resourceFile;

	private ObjectMapper objectMapper;
	private ApplicationState applicationState;

	@Override
	public ApplicationState loadInitialState() {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		try {
			applicationState = objectMapper.readValue(resourceFile.getInputStream(), ApplicationState.class);
			Map<String, List<EventMarket>> marketsMap = loadMarketsForEvents();
			applicationState.getEvents().forEach(e -> {
				if (marketsMap.containsKey(e.getId())) {
					e.setMarkets(marketsMap.get(e.getId()));
				} else {
					e.setMarkets(new ArrayList<>());
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return applicationState;
	}

	private Map<String, List<EventMarket>> loadMarketsForEvents() throws IOException {
		Map<String, List<EventMarket>> result = new HashMap<>();
		JsonNode initialState = objectMapper.readTree(resourceFile.getInputStream());
		ArrayNode eventNodes = (ArrayNode) initialState.get("events");

		for (JsonNode eventNode : eventNodes) {
			ObjectNode eventObject = (ObjectNode) eventNode;
			String eventId = eventObject.get("id").asText();
			ArrayNode eventMarketNodes = (ArrayNode) eventObject.get("markets");
			result.put(eventId, createMarkets(eventMarketNodes));
		}
		return result;
	}

	private List<EventMarket> createMarkets(ArrayNode eventMarketNodes)
			throws JsonProcessingException, IllegalArgumentException {

		List<EventMarket> result = new ArrayList<>();
		for (JsonNode eventMarketNode : eventMarketNodes) {

			String marketId = eventMarketNode.get("marketId").asText();
			Market market = findMarketInState(marketId);
			ArrayNode outcomeNodes = (ArrayNode) eventMarketNode.get("outcomes");
			List<EventMarketOutcome> eventMarketOutcomes = createEventMarketOutcomes(market, outcomeNodes);

			EventMarket eventMarket = objectMapper.treeToValue(eventMarketNode, EventMarket.class);
			eventMarket.setOutcomes(eventMarketOutcomes);
			eventMarket.setMarket(market);
			result.add(eventMarket);
		}
		return result;
	}

	private Market findMarketInState(String marketId) {
		return this.applicationState.getMarkets().stream().filter(market -> market.getId().equals(marketId)).findFirst()
				.orElseThrow(() -> new InitialStateLoadingException("Market with id " + marketId + " doesn't exist"));
	}

	private List<EventMarketOutcome> createEventMarketOutcomes(Market market, ArrayNode eventMarketOutcomeNodes)
			throws JsonProcessingException, IllegalArgumentException {

		List<EventMarketOutcome> result = new ArrayList<>();
		for (JsonNode eventMarketOutcomeNode : eventMarketOutcomeNodes) {
			String outcomeId = eventMarketOutcomeNode.get("outcomeId").asText();
			MarketOutcome marketOutcome = findMarketOutcomeInState(market, outcomeId);
			EventMarketOutcome eventMarketOutcome = objectMapper.treeToValue(eventMarketOutcomeNode,
					EventMarketOutcome.class);
			eventMarketOutcome.setOutcome(marketOutcome);
			eventMarketOutcome.setOdd(eventMarketOutcomeNode.get("odds").asDouble());
			result.add(eventMarketOutcome);
		}
		return result;
	}

	private MarketOutcome findMarketOutcomeInState(Market market, String outcomeId) {
		return market.getOutcomes().stream().filter(outcome -> outcome.getId().equals(outcomeId)).findFirst()
				.orElseThrow(() -> new InitialStateLoadingException("MarketOutcome with id " + outcomeId
						+ " for Market with id " + market.getId() + " doesn't exist"));
	}

}
