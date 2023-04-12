package com.yellow.eventmarket.enums;

public enum EventStatus {

	INACTIVE("0"), ACTIVE("1");

	private String code;

	private EventStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
