package com.te.lms.enums;

public enum BatchTechnology {
	REACT("REACT"),ANGULAR("ANGULAR"),JAVAPLUSSPRINGBOOT("JAVA+SPRINGBOOT"),NODEANDEXPRESSJS("NODE&EXPRESSJS");

	private final String batchTechnology;

	BatchTechnology(String batchTechnology) {
		this.batchTechnology=batchTechnology;
	}
	public String getBatchTechnology() {
		return batchTechnology;
	}
	}

