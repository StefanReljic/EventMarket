package com.yellow.eventmarket.enums;

public enum MarketStatus {

	INACTIVE("0"), ACTIVE("1");

	private String code;

	private MarketStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
