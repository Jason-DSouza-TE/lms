package com.te.lms.dao.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.lms.entity.employee.EmployeePrimaryInfo;

public interface EmployeeDao extends JpaRepository<EmployeePrimaryInfo, String> {

	public EmployeePrimaryInfo findByEmpId(String empId);

	@Query("from EmployeePrimaryInfo where empStatus IN('INACTIVE')")
	public List<EmployeePrimaryInfo> findByEmpStatus();
	

}

