package com.te.lms.service.employee;

import com.te.lms.dto.employee.SeeEmployeeDto;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.entity.employee.EmployeePrimaryInfo;

public interface EmployeeService {

	public EmployeePrimaryInfo addEmployee(EmployeePrimaryInfo employeePrimaryInfo);

	public EmployeePrimaryInfo updateEmployee(EmployeePrimaryInfo info);

	public Boolean deleteById(String empId);

	public SeeEmployeeDto seeAll(String empId);
	
	public EmployeePrimaryInfo login();
	
	public Boolean resetPassword(ResetPassword resetPassword);

}
