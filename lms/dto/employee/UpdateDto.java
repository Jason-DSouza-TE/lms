package com.te.lms.dto.employee;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.te.lms.enums.EmpBloodGroup;
import com.te.lms.enums.EmpGender;
import com.te.lms.enums.EmpNationality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {
	private String empId;
	private String empName;
	private LocalDate empDoj;
	private LocalDate empDob;
	private EmpBloodGroup empBloodGroup;
	private String empDesignation;
	private EmpGender empGender;
	private EmpNationality empNationality;

}
