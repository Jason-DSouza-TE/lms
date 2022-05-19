package com.te.lms.service.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.admin.AddMentorDao;
import com.te.lms.dao.employee.EmployeeDao;
import com.te.lms.dao.mentor.AttendanceDao;
import com.te.lms.dao.mentor.MentorDao;
import com.te.lms.dto.admin.SearchById;
import com.te.lms.dto.mentor.Attendance;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendance;
import com.te.lms.entity.mentor.MockDetails;

@Service
public class MentorServiceImpl implements MentorService {
	@Autowired
	private MentorDao mentorDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private AttendanceDao attendanceDao;
	@Autowired
	private AddMentorDao addMentorDao;

	@Override
	public MockDetails addMock(MockDetails details) {
		return mentorDao.save(details);
	}

	@Override
	public SearchById searchById(String id) {

		SearchById searchById = new SearchById();
		Mentor findByMentorId = addMentorDao.findByMentorId(id);
		if (findByMentorId != null) {
			searchById.setId(findByMentorId.getMentorId());
			searchById.setEmpDesignation("mentor");
			searchById.setName(findByMentorId.getMentorName());
			searchById.setSkills(findByMentorId.getTechnicalSkills());
			searchById.setEmail(findByMentorId.getMentorEmail());
			return searchById;
		} else {
			EmployeePrimaryInfo findByEmpId = employeeDao.findByEmpId(id);
			if (findByEmpId != null) {
				searchById.setEmail(findByEmpId.getEmpMail());
				searchById.setEmpDesignation(findByEmpId.getEmpDesignation());
				searchById.setId(findByEmpId.getEmpId());
				searchById.setEmpStatus(findByEmpId.getEmpStatus());
				searchById.setName(findByEmpId.getEmpName());
				searchById.setEmpGender(findByEmpId.getEmpGender());
				return searchById;
			} else {
				return null;
			}
		}
	}

	@Override
	public Boolean resetPassword(ResetPassword resetPassword) {
		Mentor findByMentorId = addMentorDao.findByMentorId(resetPassword.getId());
		boolean flag = false;
		if (findByMentorId != null && resetPassword.getOldPass().equals(findByMentorId.getPassword())
				&& resetPassword.getNewPass().equals(resetPassword.getConfirmPass())) {
			findByMentorId.setPassword(resetPassword.getNewPass());
			addMentorDao.save(findByMentorId);
			flag = true;
		}
		return flag;
	}

	@Override
	public Boolean updateAttendance(List<Attendance> attendances) {
		for (Attendance attendance : attendances) {
			List<EmployeeAttendance> findByAttendanceDate = attendanceDao
					.findByAttendanceDate(attendance.getAttendanceDate());
			if (findByAttendanceDate.isEmpty()) {
				for (Attendance attendance2 : attendances) {
					EmployeeAttendance attendance1 = new EmployeeAttendance();
					attendance1.setAttendanceDate(attendance2.getAttendanceDate());
					attendance1.setAttendanceNoon(attendance2.getAttendanceNoon());
					attendance1.setAttendenceMorning(attendance2.getAttendenceMorning());
					attendance1.setEmployee(employeeDao.findByEmpId(attendance2.getEmpId()));
					attendanceDao.save(attendance1);
				}
			} else {
					List<EmployeeAttendance> list = attendanceDao
							.findByEmployee(employeeDao.findByEmpId(attendance.getEmpId()));
					for (EmployeeAttendance attendance3 : list) {
						attendance3.setAttendanceNoon(attendance.getAttendanceNoon());
						attendance3.setAttendenceMorning(attendance3.getAttendenceMorning());
						attendance3.setAttendenceKey(attendance3.getAttendenceKey());
						attendanceDao.save(attendance3);
					}
			}
		}
		return true;
	}

}
