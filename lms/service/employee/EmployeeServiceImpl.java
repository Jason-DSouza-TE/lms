package com.te.lms.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.admin.RequestList;
import com.te.lms.dao.employee.EmployeeDao;
import com.te.lms.dao.mentor.AttendanceDao;
import com.te.lms.dto.employee.SeeEmployeeDto;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.entity.admin.EmployeeRegistrationRequestList;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendance;
import com.te.lms.enums.Status;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	private SeeEmployeeDto seeEmployeeDto;
	@Autowired
	private RequestList requestList;
	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public EmployeePrimaryInfo addEmployee(EmployeePrimaryInfo info) {
		EmployeePrimaryInfo primaryInfo = employeeDao.findByEmpId(info.getEmpId());
		if (primaryInfo != null) {
			return null;
		} else {
			info.setEmpStatus(Status.INACTIVE);
			return employeeDao.save(info);
		}

	}

	@Override
	public EmployeePrimaryInfo updateEmployee(EmployeePrimaryInfo info) {
		EmployeePrimaryInfo primaryInfo = employeeDao.findByEmpId(info.getEmpId());

		if (primaryInfo != null) {
			String string = primaryInfo.getEmpPassword();
			Status status = primaryInfo.getEmpStatus();
			EmployeeRegistrationRequestList employeeRegistrationRequestList = requestList.findByEmployee(primaryInfo);
			if (employeeRegistrationRequestList != null) {
				requestList.delete(employeeRegistrationRequestList);
			}
			List<EmployeeAttendance> attendance = attendanceDao.findByEmployee(primaryInfo);
			if (attendance != null) {
				for (EmployeeAttendance employeeAttendance : attendance) {
					attendanceDao.delete(employeeAttendance);
				}
			}
			
			employeeDao.deleteById(info.getEmpId());
			info.setEmpPassword(string);
			info.setEmpStatus(status);
			employeeDao.save(info);
			if (attendance != null) {
				for (EmployeeAttendance employeeAttendance : attendance) {
					attendanceDao.save(employeeAttendance);
				}
			}
			if (employeeRegistrationRequestList != null) {
				requestList.save(employeeRegistrationRequestList);
			}
			return info;
		} else {
			return null;
		}
	}

	@Override
	public SeeEmployeeDto seeAll(String empId) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeDao.getById(empId);
		if (seeEmployeeDto != null) {

			seeEmployeeDto.setDegree(employeePrimaryInfo.getDegree());
			seeEmployeeDto.setEmpBloodGroup(employeePrimaryInfo.getEmpBloodGroup());
			seeEmployeeDto.setEmpDesignation(employeePrimaryInfo.getEmpDesignation());
			seeEmployeeDto.setEmpName(employeePrimaryInfo.getEmpName());
			seeEmployeeDto.setEmpDob(employeePrimaryInfo.getEmpDob());
			seeEmployeeDto.setEmpDoj(employeePrimaryInfo.getEmpDoj());
			seeEmployeeDto.setEmpGender(employeePrimaryInfo.getEmpGender());
			seeEmployeeDto.setEmpId(employeePrimaryInfo.getEmpId());
			seeEmployeeDto.setEmpNationality(employeePrimaryInfo.getEmpNationality());
			seeEmployeeDto.setEmpStatus(employeePrimaryInfo.getEmpStatus());
		}
		return seeEmployeeDto;
	}

	@Override
	public EmployeePrimaryInfo login() {
		return null;
	}

	@Override
	public Boolean deleteById(String empId) {
		EmployeePrimaryInfo findByEmpId = employeeDao.findByEmpId(empId);
		if (findByEmpId != null) {

			EmployeeRegistrationRequestList findByEmployee2 = requestList.findByEmployee(findByEmpId);
			if (findByEmployee2 != null) {
				requestList.delete(findByEmployee2);
			}
			List<EmployeeAttendance>  findByEmployee = attendanceDao.findByEmployee(findByEmpId);
			
			if (findByEmployee != null) {
				for (EmployeeAttendance employeeAttendance : findByEmployee) {
					attendanceDao.delete(employeeAttendance);
				}
			}
			employeeDao.delete(findByEmpId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean resetPassword(ResetPassword resetPassword) {
		EmployeePrimaryInfo findByEmpId = employeeDao.findByEmpId(resetPassword.getId());
		boolean flag = false;
		if (findByEmpId != null && resetPassword.getOldPass().equals(findByEmpId.getEmpPassword()) && resetPassword.getNewPass().equals(resetPassword.getConfirmPass())) {
					findByEmpId.setEmpPassword(resetPassword.getNewPass());
					findByEmpId.setIsEmailVerified(1);
					employeeDao.save(findByEmpId);
					flag = true;
		}
		return flag;
	}
}
