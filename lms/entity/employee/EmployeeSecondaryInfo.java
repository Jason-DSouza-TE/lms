package com.te.lms.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.te.lms.enums.MaritalStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo {

	@Id
	@Column(name="pan_no")
	private String panNo;
	@Column(name="aadhaar_no")
	private String aadhaarNo;
	@Column(name="father_name")
	private String fatherName;
	@Column(name="marital_status")
	@Enumerated(EnumType.ORDINAL)
	private MaritalStatus maritalStatus;
	@Column(name="mother_name")
	private String motherName;
	@Column(name="passport_no")
	private String passportNo;
	@Column(name="spouse_name")
	private String spouseName;
	
}

