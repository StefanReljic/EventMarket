package com.yellow.eventmarket.enums;

public enum EventMarketStatus {

	INACTIVE("0"), ACTIVE("1");

	private String code;

	private EventMarketStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
