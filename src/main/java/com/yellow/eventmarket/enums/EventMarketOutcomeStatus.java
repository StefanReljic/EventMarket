package com.yellow.eventmarket.enums;

public enum EventMarketOutcomeStatus {

	INACTIVE(0), ACTIVE(1);

	private Integer code;

	private EventMarketOutcomeStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static EventMarketOutcomeStatus fromCode(Integer code) {
		for (EventMarketOutcomeStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

}
