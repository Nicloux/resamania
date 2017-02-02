package com.resamania.booking.api;

public enum ResamaniaApiTarget {

	SUPPLIER("supplier"), 
	COACH("coach"), 
	ACTIVITY("activity"), 
	ROOM("room"),
	BOOKING("booking");

	private String target;

	private ResamaniaApiTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return this.target;
	}
}
