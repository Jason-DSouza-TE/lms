package com.te.lms.enums;

public enum EmpGender {
	M("M"), F("F"), O("O");

	private final String empGender;

	EmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpGender() {
		return empGender;
	}
}
