package com.te.lms.entity.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.te.lms.enums.AddressType;
import com.te.lms.enums.State;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_address_info")
public class EmployeeAddressInfo {
	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	@Column(name = "address_type")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	@Column(name = "city")
	private String city;
	@Column(name = "door_no")
	private String doorNo;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "locality")
	private String locality;
	@Column(name = "pincode")
	private Integer pincode;
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private State state;
	@Column(name = "street")
	private String street;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "employee_primary_info_address", 
//	joinColumns = @JoinColumn(name = "address_address_id"), 
//	inverseJoinColumns = @JoinColumn(name = "employee_emp_id"))
//	private List<EmployeePrimaryInfo> employeePrimaryInfo2;

}
