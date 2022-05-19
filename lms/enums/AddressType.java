package com.te.lms.enums;

public enum AddressType {
	PERMANENT("PERMANENT"), TEMPORARY("TEMPORARY");
	private final String addressType;

	AddressType(String addressType) {
		this.addressType = addressType;
	}

	private String getAddressType() {
		return addressType;
		
	}
}
