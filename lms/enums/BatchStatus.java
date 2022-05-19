package com.te.lms.enums;

public enum BatchStatus {
	STARTED("STARTED"), ONGOING("ONGOING"), ENDED("ENDED"), TERMINATED("TERMINATED");

	private final String batchStatus;

	BatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getBatchStatus() {
		return batchStatus;
	}
	
	
}
