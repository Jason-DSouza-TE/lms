package com.te.lms.enums;

public enum AccountType {
	SAVINGS("SAVINGS"), CURRENT("CURRENT"), SALARY("SALARY");

	private final String accountType;

	AccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;

	}
}
