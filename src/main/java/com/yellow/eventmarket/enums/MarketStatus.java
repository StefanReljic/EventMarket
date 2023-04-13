package com.yellow.eventmarket.enums;

public enum MarketStatus {

	INACTIVE(0), ACTIVE(1);

	private Integer code;

	private MarketStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static MarketStatus fromCode(Integer code) {
		for (MarketStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

}
