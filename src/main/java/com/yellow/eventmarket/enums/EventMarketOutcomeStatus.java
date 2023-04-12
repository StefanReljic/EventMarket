package com.yellow.eventmarket.enums;

public enum EventMarketOutcomeStatus {

	INACTIVE("0"), ACTIVE("1");

	private String code;

	private EventMarketOutcomeStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
