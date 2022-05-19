package com.te.lms.enums;

public enum EducationType {
	SSLC("SSLC"), TENTH("TENTH"), PUC("PUC"), DIPLOMA("DIPLOMA"), ITI("ITI"), ENGINEERING("ENGINEERING"), BSC("BSC"),
	BCA("BCA"), BCOM("BCOM"), M_TECH("M_TECH"), MSC("MSC"), MCA("MCA"), MCOM("MCOM");

	private final String educationType;

	EducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getEducationType() {
		return educationType;

	}
}
