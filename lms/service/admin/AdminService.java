package com.te.lms.service.admin;

import java.util.List;

import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.EmployeeInactiveDto;
import com.te.lms.dto.admin.SearchById;

public interface AdminService {
	public AddMentorDto addMentor(AddMentorDto mentorDto);

	public AddMentorDto updateMentor(AddMentorDto updateDto);

	public Boolean deleteMentor(String mentorId);

	public AddBatchDto addBatch(AddBatchDto addBatchDto);

	public AddBatchDto updateBatch(AddBatchDto updateBatchDto);

	public Boolean deleteBatch(String batchId);

	public List<EmployeeInactiveDto> approval();

	public Boolean approveEmp(ApprovalDto approval);

	public Boolean rejectEmp(ApprovalDto approvalDto);

	public List<AllMentorsDto> allMentors();
	
	public List<AllBatchesDto> allBatches();
	
	public SearchById searchById(String id);

}
