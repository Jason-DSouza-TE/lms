package com.te.lms.entity.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_education_details_info")
public class EmployeeEducationDetailsInfo {
	@Id
	@Column(name = "education_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	@Column(name = "education_type")
	private String educationType;
	@Column(name = "institute_name")
	private String instituteName;
	@Column(name = "percentage")
	private Double percentage;
	@Column(name = "specialization")
	private String specialization;
	@Column(name = "state")
	private String state;
	@Column(name = "university_name")
	private String universityName;
	@Column(name = "year_of_passing")
	private Integer yearOfPassing;
//
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "employee_primary_info_education_details", 
//	joinColumns = @JoinColumn(name = "education_details_education_id"), 
//	inverseJoinColumns = @JoinColumn(name = "employee_emp_id"))
//	private List<EmployeePrimaryInfo> employeePrimaryInfo3;
}
