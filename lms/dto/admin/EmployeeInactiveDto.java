package com.te.lms.dto.admin;

import java.util.List;

import org.springframework.stereotype.Component;

import com.te.lms.entity.employee.EmployeeContactInfo;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeInactiveDto {
private String empId;
private String empName;
private Status empStatus;
private List<EmployeeContactInfo> employeeContactInfo;
private List<EmployeeEducationDetailsInfo> employeeEducationDetailsInfo;	

}
