package com.te.lms.enums;

public enum EmpBloodGroup {
	O_NEGATIVE("O_NEGATIVE"), O_POSITIVE("O_POSITIVE"), A_NEGATIVE("A_NEGATIVE"), B_NEGATIVE("B_NEGATIVE"),
	B_POSITIVE("B_POSITIVE"), AB_NEGATIVE("AB_NEGATIVE"),AB_POSITIVE("AB_POSITIVE");

	private final String empBloodGroup;
	
	EmpBloodGroup(String bloodGroup) {
	this.empBloodGroup=bloodGroup;
	}
	public String getBloodGroup() {
		return empBloodGroup;
	}
}
