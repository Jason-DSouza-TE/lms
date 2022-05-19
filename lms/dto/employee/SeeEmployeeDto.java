package com.te.lms.dto.employee;

import java.time.LocalDate;


import org.springframework.stereotype.Component;

import com.te.lms.enums.EmpBloodGroup;
import com.te.lms.enums.EmpGender;
import com.te.lms.enums.EmpNationality;
import com.te.lms.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeeEmployeeDto {
	private String empId;
	private EmpBloodGroup empBloodGroup;
	private LocalDate empDob;
	private LocalDate empDoj;
	private String degree;
	private String empDesignation;
	private String empName;
	private EmpGender empGender;
	private EmpNationality empNationality;
	private Status empStatus;
}
