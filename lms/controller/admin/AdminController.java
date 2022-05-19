package com.te.lms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.EmployeeInactiveDto;
import com.te.lms.dto.admin.SearchById;
import com.te.lms.response.ResponseBody;
import com.te.lms.service.admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private ResponseBody response;

	@PostMapping("/mentor")
	public ResponseEntity<ResponseBody> addMentor(@RequestBody AddMentorDto mentorDto) {
		AddMentorDto addMentor = adminService.addMentor(mentorDto);
		if (addMentor != null) {
			response.setIsError(false);
			response.setMessage("Mentor added successfully");
			response.setData(addMentor);
			return new ResponseEntity<>(response,HttpStatus.OK);

		} else {
			response.setIsError(true);
			response.setMessage("Mentor could not be added");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/mentor")
	public ResponseEntity<ResponseBody> updateMentor(@RequestBody AddMentorDto updateDto) {
		AddMentorDto updateMentor = adminService.updateMentor(updateDto);
		if (updateMentor != null) {
			response.setIsError(false);
			response.setMessage("Mentor updated successfully");
			response.setData(updateMentor);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Mentor could not be updated");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/mentor/{mentorId}")
	public ResponseEntity<ResponseBody> deleteMentor(@PathVariable String mentorId) {
		adminService.deleteMentor(mentorId);
		if (Boolean.TRUE.equals(adminService.deleteMentor(mentorId))) {
			response.setIsError(false);
			response.setMessage("Data deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Mentor not found");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/batch")
	public ResponseEntity<ResponseBody> addBatch(@RequestBody AddBatchDto addBatchDto) {
		AddBatchDto addBatch = adminService.addBatch(addBatchDto);

		if (addBatch != null) {
			response.setIsError(false);
			response.setMessage("Batch added successfully");
			response.setData(addBatch);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Batch could not be added");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/batch")
	public ResponseEntity<ResponseBody> updateBatch(@RequestBody AddBatchDto updaBatchDto) {
		AddBatchDto updateBatch = adminService.updateBatch(updaBatchDto);

		if (updateBatch != null) {
			response.setIsError(false);
			response.setMessage("Batch updated successfully");
			response.setData(updateBatch);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Batch could not be updated");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/batch/{batchId}")
	public ResponseEntity<ResponseBody> deleteBatch(@PathVariable String batchId) {
		if (Boolean.TRUE.equals(adminService.deleteBatch(batchId))) {
			response.setIsError(false);
			response.setMessage("Data deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Batch not found");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/employee")
	public ResponseEntity<ResponseBody> getApproval() {
		List<EmployeeInactiveDto> employeeInactiveDtos = adminService.approval();
		if (employeeInactiveDtos != null) {
			response.setIsError(false);
			response.setMessage("The employees to be approved are : ");
			response.setData(employeeInactiveDtos);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Employees not found");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/employee")
	public ResponseEntity<ResponseBody> approval(@RequestBody ApprovalDto approval) {
		if (Boolean.TRUE.equals(adminService.approveEmp(approval))) {
			response.setIsError(false);
			response.setMessage("Employee Approved");
			response.setData(approval);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Error");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/employeeReject")
	public ResponseEntity<ResponseBody> rejection(@RequestBody ApprovalDto requestList) {
		if (Boolean.TRUE.equals(adminService.rejectEmp(requestList))) {
			response.setIsError(false);
			response.setMessage("Rejection done");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Error");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mentors")
	public ResponseEntity<ResponseBody> mentors() {
		List<AllMentorsDto> allMentors = adminService.allMentors();

		if (allMentors != null) {
			response.setIsError(false);
			response.setMessage("The list 0f mentors : ");
			response.setData(allMentors);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Mentors not found");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/batches")
	public ResponseEntity<ResponseBody> batches() {
		List<AllBatchesDto> allBatches = adminService.allBatches();
		if (allBatches != null) {
			response.setIsError(false);
			response.setMessage("The list 0f mentors : ");
			response.setData(allBatches);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Mentors not found");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
@GetMapping("/search/{id}")
	public ResponseEntity<ResponseBody> searchById(@PathVariable String id) {
		SearchById searchById = adminService.searchById(id);
		if (searchById != null) {
			response.setIsError(false);
			response.setMessage("Employee/Mentor found ");
			response.setData(searchById);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Employee/Mentor not found");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
}
