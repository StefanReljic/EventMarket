package com.yellow.eventmarket.enums;

public enum EventStatus {

	INACTIVE(0), ACTIVE(1);

	private Integer code;

	private EventStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static EventStatus fromCode(Integer code) {
		for (EventStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}
}
