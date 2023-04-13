package com.yellow.eventmarket.enums;

public enum EventMarketStatus {

	INACTIVE(0), ACTIVE(1);

	private Integer code;

	private EventMarketStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static EventMarketStatus fromCode(Integer code) {
		for (EventMarketStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

}
