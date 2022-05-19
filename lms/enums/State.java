package com.te.lms.enums;

public enum State {
	KARNATAKA("KARNATAKA"), TAMIL_NADU("TAMIL_NADU"), ANDHRA_PRADESH("ANDHRA_PRADESH"), KERALA("KERALA"),
	MAHARASHTRA("MAHARASHTRA"), TELANGANA("TELANGANA");

	private final String state;

	State(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
