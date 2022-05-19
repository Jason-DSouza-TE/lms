package com.te.lms.enums;

public enum Status {
	ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), ABSCONDED("ABSCONDED"), TERMINATED("TERMINATED");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
