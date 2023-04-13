package com.yellow.eventmarket.enums;

public enum MarketOutcomeStatus {

	INACTIVE(0), ACTIVE(1);

	private Integer code;

	private MarketOutcomeStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static MarketOutcomeStatus fromCode(Integer code) {
		for (MarketOutcomeStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

}
