package com.te.lms.enums;

public enum EmpNationality {
	INDIA("INDIA"), PAKISTAN("PAKISTAN"), AMERICA("AMERICA"), AUSTRALIA("AUSTRALIA");

	private final String nationality;

	EmpNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationality() {
		return nationality;
	}
}
