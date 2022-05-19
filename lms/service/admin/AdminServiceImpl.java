package com.te.lms.service.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.EmailService.EmailServiceSender;
import com.te.lms.dao.admin.AddMentorDao;
import com.te.lms.dao.admin.BatchDao;
import com.te.lms.dao.admin.RequestList;
import com.te.lms.dao.employee.EmployeeDao;
import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.EmployeeInactiveDto;
import com.te.lms.dto.admin.SearchById;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.EmployeeRegistrationRequestList;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.enums.Status;
import com.te.lms.password.GeneratePassword;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AddMentorDao addMentorDao;
	@Autowired
	private BatchDao batchDao;
	@Autowired
	private EmailServiceSender emailServiceSender;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RequestList requestListDao;

	@Override
	public AddMentorDto addMentor(AddMentorDto mentorDto) {
		Mentor mentor2 = new Mentor();
		GeneratePassword password = new GeneratePassword();
		String temp = password.passwordGenerator(14);
		mentor2.setMentorEmail(mentorDto.getMentorEmail());
		mentor2.setMentorId(mentorDto.getMentorId());
		mentor2.setMentorName(mentorDto.getMentorName());
		mentor2.setTechnicalSkills(mentorDto.getTechnicalSkills());
		mentor2.setUsername(mentorDto.getUsername());
		mentor2.setPassword(temp);
		addMentorDao.save(mentor2);
		emailServiceSender.sendMail(mentor2.getMentorEmail(), "Authentication Password",
				"Your Temporary password is : " + temp);
		return mentorDto;
	}

	@Override
	public AddMentorDto updateMentor(AddMentorDto updateDto) {
		Mentor mentorUpdate = addMentorDao.findByMentorId(updateDto.getMentorId());
		if (mentorUpdate != null) {
			mentorUpdate.setMentorName(updateDto.getMentorName());
			mentorUpdate.setMentorEmail(updateDto.getMentorEmail());
			mentorUpdate.setTechnicalSkills(updateDto.getTechnicalSkills());
			mentorUpdate.setUsername(updateDto.getUsername());
			addMentorDao.save(mentorUpdate);
			return updateDto;
		} else {
			return null;
		}
	}

	@Override
	public Boolean deleteMentor(String mentorId) {
		Mentor mentor = addMentorDao.findByMentorId(mentorId);
		if (mentor != null) {
			addMentorDao.delete(mentor);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AddBatchDto addBatch(AddBatchDto addBatchDto) {
		Batch findByBatchId = new Batch();
		Mentor findByMentorId = addMentorDao.findByMentorId(addBatchDto.getMentorId());
		if (findByMentorId != null) {
			findByBatchId.setBatchId(addBatchDto.getBatchId());
			findByBatchId.setBatchName(addBatchDto.getBatchName());
			findByBatchId.setBatchTechnology(addBatchDto.getBatchTechnology());
			findByBatchId.setBatchEndDate(addBatchDto.getBatchEndDate());
			findByBatchId.setBatchStartDate(addBatchDto.getBatchStartDate());
			findByBatchId.setBatchStatus(addBatchDto.getBatchStatus());
			findByBatchId.setBatchMentor(findByMentorId);
			batchDao.save(findByBatchId);
			return addBatchDto;
			
		}else {
			return null;
		}

	}

	@Override
	public AddBatchDto updateBatch(AddBatchDto updaBatchDto) {
		Batch findByBatchId = batchDao.findByBatchId(updaBatchDto.getBatchId());
		if (findByBatchId != null) {
			findByBatchId.setBatchStatus(updaBatchDto.getBatchStatus());
			findByBatchId.setBatchEndDate(updaBatchDto.getBatchEndDate());
			findByBatchId.setBatchTechnology(updaBatchDto.getBatchTechnology());
			findByBatchId.setBatchMentor(addMentorDao.findByMentorId(updaBatchDto.getMentorId()));
			batchDao.save(findByBatchId);
			return updaBatchDto;
		}else {
			return null;
		}
	}

	@Override
	public Boolean deleteBatch(String batchId) {
		Batch batch = batchDao.findByBatchId(batchId);
		if (batch != null) {
			batchDao.delete(batch);
			return true;
		} else {
			return false;
		}

	}

	public EmployeeInactiveDto convertEntityToDto(EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeeInactiveDto dto = new EmployeeInactiveDto();
		dto.setEmpId(employeePrimaryInfo.getEmpId());
		dto.setEmpName(employeePrimaryInfo.getEmpName());
		dto.setEmpStatus(employeePrimaryInfo.getEmpStatus());
		dto.setEmployeeEducationDetailsInfo(employeePrimaryInfo.getEducationDetailsInfos());
		dto.setEmployeeContactInfo(employeePrimaryInfo.getEmployeeContactInfos());
		return dto;
	}

	@Override
	public List<EmployeeInactiveDto> approval() {
		return employeeDao.findByEmpStatus().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public Boolean approveEmp(ApprovalDto approval) {
		GeneratePassword password = new GeneratePassword();
		String passwordGenerator = password.passwordGenerator(10);
		Batch findByBatchId = batchDao.findByBatchId(approval.getBatchId());
		if (findByBatchId != null) {
			EmployeePrimaryInfo employeePrimaryInfo = employeeDao.findByEmpId(approval.getEmpId());
			employeePrimaryInfo.setEmpPassword(passwordGenerator);
			EmployeeRegistrationRequestList requestList = new EmployeeRegistrationRequestList();
			requestList.setBatchId(approval.getBatchId());
			requestList.setBatchName(approval.getBatchName());
			requestList.setIsRejected(0);
			requestList.setRejectionReason(null);
			approval.setEmpName(employeePrimaryInfo.getEmpName());
			employeePrimaryInfo.setEmpStatus(Status.ACTIVE);
			employeePrimaryInfo.setInBatch(findByBatchId);
			employeeDao.save(employeePrimaryInfo);
			requestList.setEmployee(employeePrimaryInfo);
			requestListDao.save(requestList);
			String email = requestList.getEmployee().getEmpMail();
			emailServiceSender.sendMail(email, "Registration Approval Mail",
					"You have been registered to the company. your temporary password is : " + passwordGenerator);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public Boolean rejectEmp(ApprovalDto approvalDto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeDao.findByEmpId(approvalDto.getEmpId());
		String email = employeePrimaryInfo.getEmpMail();
		EmployeeRegistrationRequestList requestList = new EmployeeRegistrationRequestList();
		requestList.setIsRejected(1); //change to boolean
		requestList.setRejectionReason(approvalDto.getRejectionReason());
		requestList.setEmployee(employeePrimaryInfo);
		requestListDao.save(requestList);
		emailServiceSender.sendMail(email, "Rejection Mail",
				"We are sorry to inform that your registration could not be approved.");
		return true;
	}

	public AllMentorsDto convertMentorDto(Mentor mentor) {
		AllMentorsDto allMentorsDto = new AllMentorsDto();
		allMentorsDto.setMentorEmail(mentor.getMentorEmail());
		allMentorsDto.setMentorId(mentor.getMentorId());
		allMentorsDto.setMentorName(mentor.getMentorName());
		allMentorsDto.setTechnicalSkills(mentor.getTechnicalSkills());
		return allMentorsDto;
	}

	@Override
	public List<AllMentorsDto> allMentors() {
		return addMentorDao.findAll().stream().map(this::convertMentorDto).collect(Collectors.toList());
	}

	public AllBatchesDto convertBatchDto(Batch batch) {
		AllBatchesDto allBatchesDto = new AllBatchesDto();
		allBatchesDto.setBatchId(batch.getBatchId());
		allBatchesDto.setBatchName(batch.getBatchName());
		allBatchesDto.setBatchEndDate(batch.getBatchEndDate());
		allBatchesDto.setBatchStartDate(batch.getBatchStartDate());
		allBatchesDto.setBatchStatus(batch.getBatchStatus());
		allBatchesDto.setBatchTechnology(batch.getBatchTechnology());
		allBatchesDto.setMentorName(batch.getBatchMentor().getMentorName());
		return allBatchesDto;
	}

	@Override
	public List<AllBatchesDto> allBatches() {
		return batchDao.findAll().stream().map(this::convertBatchDto).collect(Collectors.toList());
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

}
