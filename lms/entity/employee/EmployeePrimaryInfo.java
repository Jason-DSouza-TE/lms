package com.te.lms.entity.employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.entity.admin.Batch;
import com.te.lms.enums.EmpBloodGroup;
import com.te.lms.enums.EmpGender;
import com.te.lms.enums.EmpNationality;
import com.te.lms.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_primary_Info")
public class EmployeePrimaryInfo {
	@Id
	@Column(name = "emp_id")
	private String empId;
	@Column(name = "emp_blood_group")
	@Enumerated(EnumType.ORDINAL)
	private EmpBloodGroup empBloodGroup;
	@Column(name = "emp_dob")
	private LocalDate empDob;
	@Column(name = "emp_doj")
	private LocalDate empDoj;
	@Column(name = "degree")
	private String degree;
	@Column(name = "designation")
	private String empDesignation;
	@Column(name = "emp_email")
	private String empMail;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private EmpGender empGender;
	@Column(name = "is_email_verified")
	private Integer isEmailVerified;
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	@Column(name = "nationality")
	@Enumerated(EnumType.STRING)
	private EmpNationality empNationality;
	@Column(name = "password")
	private String empPassword;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status empStatus;
	@Column(name = "username")
	private String username;

	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeSecondaryInfo secondaryInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeBankDetailsInfo bankDetails;
	@OneToOne
	private Batch inBatch;

	@ManyToMany(cascade = CascadeType.ALL) // , mappedBy = "employeePrimaryInfo1")
	@JoinTable(name = "employee_primary_info_experience", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "experience_experience_id"))
	private List<EmployeeExperienceInfo> employeeExperienceInfos;

	@ManyToMany(cascade = CascadeType.ALL) // , mappedBy = "employeePrimaryInfo2")
	@JoinTable(name = "employee_primary_info_address", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "address_address_id"))
	private List<EmployeeAddressInfo> employeeAddressInfos;

	@ManyToMany(cascade = CascadeType.ALL) // , mappedBy = "employeePrimaryInfo3")
	@JoinTable(name = "employee_primary_info_education_details", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "education_details_education_id"))
	private List<EmployeeEducationDetailsInfo> educationDetailsInfos;

	@ManyToMany(cascade = CascadeType.ALL) // , mappedBy = "employeePrimaryInfo4")
	@JoinTable(name = "employee_primary_info_contacts", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "contacts_contact_number"))
	private List<EmployeeContactInfo> employeeContactInfos;

	@ManyToMany(cascade = CascadeType.ALL) // , mappedBy = "employeePrimaryInfo5")
	@JoinTable(name = "employee_primary_info_technical_skill", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "technical_skill_skill_id"))
	private List<EmployeeTechnicalSkillsInfo> employeeTechnicalSkillsInfos;
}
