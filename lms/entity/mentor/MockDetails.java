package com.te.lms.entity.mentor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name = "mock_details")
public class MockDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mock_id")
	private Integer mockId;
	@Column(name="mock_date")
	private LocalDate mockDate;
	@Column(name="mock_feedback")
	private String mockFeedback;
	@Column(name="mock_on")
	private Integer mockNo; 
	@Column(name="mock_rating")
	private Integer mockRating;
	@Column(name="mock_type")
	private Integer mockType;
	@Column(name="practical")
	private Integer practical; 
	@Column(name="theoritical")
	private Integer theoritical;
	@Column(name="employee_emp_id")
	private String employeeEmpId;
	
	

	

}


