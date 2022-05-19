package com.te.lms.service.mentor;

import java.util.List;

import com.te.lms.dto.admin.SearchById;
import com.te.lms.dto.mentor.Attendance;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.entity.mentor.MockDetails;

public interface MentorService {
	public MockDetails addMock(MockDetails details);

	public SearchById searchById(String id);

	public Boolean resetPassword(ResetPassword resetPassword);

	public Boolean updateAttendance(List<Attendance> attendances);
}
