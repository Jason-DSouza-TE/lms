package com.te.lms.controller.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.admin.SearchById;
import com.te.lms.dto.mentor.Attendance;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.response.ResponseBody;
import com.te.lms.service.mentor.MentorService;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	@Autowired
	private MentorService mentorService;
	@Autowired
	private ResponseBody response;

	@PostMapping("/attendance")
	public ResponseEntity<ResponseBody> updateAttendance(@RequestBody List<Attendance> attendance) {
		if (Boolean.TRUE.equals(mentorService.updateAttendance(attendance))) {
			response.setIsError(false);
			response.setMessage("Attendance updated successfully");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Attendance could not be updated");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<ResponseBody> searchById(@PathVariable String id) {
		SearchById searchById = mentorService.searchById(id);
		if (searchById != null) {
			response.setIsError(false);
			response.setMessage("Employee/Mentor Found");
			response.setData(searchById);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Employee/Mentor not Found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/reset")
	public ResponseEntity<ResponseBody> resetPassword(@RequestBody ResetPassword resetPassword) {
		if (Boolean.TRUE.equals(mentorService.resetPassword(resetPassword))) {
			response.setIsError(false);
			response.setMessage("Password reset successful");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Password reset failed");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
