package com.te.lms.entity.mentor;

import java.time.LocalDate;

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
@Table(name = "employee_attendence")
public class EmployeeAttendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendence_key")
	private Integer attendenceKey;
	@Column(name = "attendence_morning")
	private Integer attendenceMorning;
	@Column(name = "attendence_noon")
	private Integer attendanceNoon;
	@Column(name = "attendance_date")
	private LocalDate attendanceDate;
	
	
	@OneToOne
	private EmployeePrimaryInfo   employee;
	
	

}
