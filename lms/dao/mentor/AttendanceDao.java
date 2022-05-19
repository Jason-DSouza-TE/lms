package com.te.lms.dao.mentor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendance;


public interface AttendanceDao extends JpaRepository<EmployeeAttendance, LocalDate> {

	public List<EmployeeAttendance> findByEmployee(EmployeePrimaryInfo findByEmpId);
	
	public List<EmployeeAttendance> findByAttendanceDate(LocalDate attendanceDate);
	
	
}
