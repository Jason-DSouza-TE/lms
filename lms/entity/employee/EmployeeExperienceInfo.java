package com.te.lms.entity.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_experience_info")
public class EmployeeExperienceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private Integer experienceId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="data_of_joining")
	private LocalDate dataOfJoining;
	@Column(name="data_of_relieving")
	private LocalDate dataOfRelieving;
	@Column(name="designation")
	private String designation;
	@Column(name="location")
	private String location;
	@Column(name="years_of_experience")
	private Double yearsOfExperience;

	
//	  @ManyToMany(cascade = CascadeType.ALL)	  
//	  @JoinTable(name = "employee_primary_info_experience", joinColumns = @JoinColumn(name =
//	  "experienc_experience_id"), inverseJoinColumns = @JoinColumn(name = "employee_emp_id"))
//	  private List<EmployeePrimaryInfo> employeePrimaryInfo1;
	  
	 
}
