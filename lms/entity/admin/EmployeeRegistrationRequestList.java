package com.te.lms.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.entity.employee.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_registration_request_list")
public class EmployeeRegistrationRequestList {
	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestId;
	@Column(name = "batch_id")
	private String batchId;
	@Column(name = "batch_name")
	private String batchName;
	@Column(name = "is_rejected")
	private Integer isRejected;
	@Column(name = "rejection_reason")
	private String rejectionReason;
	
	
	@OneToOne
	private EmployeePrimaryInfo employee;

}
