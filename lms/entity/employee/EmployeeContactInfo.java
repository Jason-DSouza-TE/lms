package com.te.lms.entity.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.te.lms.enums.ContactType;

import lombok.Data;
@Data
@Entity
@Table(name="employee_contact_info")
public class EmployeeContactInfo {
	@Id
	@Column(name="contact_number")
	private Long contactNumber;
	@Column(name="contact_type")
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "employee_primary_info_contacts", 
//	joinColumns = @JoinColumn(name = "contacts_contact_number"), 
//	inverseJoinColumns = @JoinColumn(name = "employee_emp_id"))
//	private List<EmployeePrimaryInfo> employeePrimaryInfo4;
}
