package com.te.lms.controller.employee;

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

import com.te.lms.dto.employee.SeeEmployeeDto;
import com.te.lms.dto.mentor.ResetPassword;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.response.ResponseBody;
import com.te.lms.service.employee.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@Autowired
	private ResponseBody response;

	@PostMapping("/employee")
	public ResponseEntity<ResponseBody> addEmployee(@RequestBody EmployeePrimaryInfo info) {
		EmployeePrimaryInfo employee = service.addEmployee(info);
		if (employee != null) {
			response.setIsError(false);
			response.setMessage("Success");
			response.setData(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Failed, employee ID already exists");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<ResponseBody> deleteAll(@PathVariable String empId) {

		if (Boolean.TRUE.equals(service.deleteById(empId))) {
			response.setMessage("deleted successfully");
			response.setIsError(false);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("Employee Not Found");
			response.setIsError(true);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/employee")
	public ResponseEntity<ResponseBody> updateEmployee(@RequestBody EmployeePrimaryInfo info) {
		EmployeePrimaryInfo employee = service.updateEmployee(info);
		if (employee != null) {
			response.setIsError(false);
			response.setMessage("updated successfully");
			response.setData(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Failed, employee ID doesn't exists");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<ResponseBody> seeAll(@PathVariable String empId) {
		SeeEmployeeDto seeEmp = service.seeAll(empId);
		if (seeEmp != null) {
			response.setIsError(false);
			response.setMessage("Details Found");
			response.setData(seeEmp);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Failed, employee ID doesn't exists");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/reset")
	public ResponseEntity<ResponseBody> resetPassword(@RequestBody ResetPassword resetPassword) {
		if (Boolean.TRUE.equals(service.resetPassword(resetPassword))) {
			response.setIsError(false);
			response.setMessage("Password reset successful");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMessage("Password reset failed!");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}