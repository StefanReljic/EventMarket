package com.yellow.eventmarket.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.eventmarket.dto.MarketDTO;
import com.yellow.eventmarket.dto.MarketOutcomeDTO;
import com.yellow.eventmarket.kafka.producer.MarketStreamProducer;
import com.yellow.eventmarket.model.Market;
import com.yellow.eventmarket.model.MarketOutcome;

@RestController
@RequestMapping("/markets")
public class MarketController {

	@Autowired
	private MarketStreamProducer marketStreamProducer;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<?> createMarket(@RequestBody Market market) {

//
//		TypeMap<MarketOutcomeDTO, MarketOutcome> propertyMapper = this.modelMapper.createTypeMap(MarketOutcomeDTO.class,
//				MarketOutcome.class);
//
//		Converter<List<MarketOutcomeDTO>, List<MarketOutcome>> convertIdentities = new AbstractConverter<>() {
//			protected List<MarketOutcome> convert(List<MarketOutcomeDTO> source) {
//				return source.stream().map(identity -> modelMapper.map(identity, MarketOutcome.class))
//						.collect(Collectors.toList());
//			}
//		};
//
//		modelMapper.typeMap(MarketDTO.class, Market.class).addMappings(
//				mapper -> mapper.using(convertIdentities).map(MarketDTO::getMarketOutcomes, Market::setMarketOutcomes));
//		Market market = modelMapper.map(marketDTO, Market.class);
//		System.err.println(market.getStatus());
		marketStreamProducer.sendMarketToStream(market);
		return ResponseEntity.ok().build();
	}

}
