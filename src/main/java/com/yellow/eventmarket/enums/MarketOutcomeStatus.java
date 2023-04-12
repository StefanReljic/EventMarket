package com.yellow.eventmarket.enums;

public enum MarketOutcomeStatus {

	INACTIVE("0"), ACTIVE("1");

	private String code;

	private MarketOutcomeStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
