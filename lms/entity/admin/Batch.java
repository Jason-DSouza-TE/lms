package com.te.lms.entity.admin;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.enums.BatchStatus;
import com.te.lms.enums.BatchTechnology;

import lombok.Data;

@Entity
@Data
@Table(name = "batch")
public class Batch {

	
	@Id
	@Column(name="batch_id")
	private String batchId;
	@Column(name="batch_end_date")
	private LocalDate batchEndDate;
	@Column(name="batch_name")
	private String batchName;
	@Column(name="batch_start_date")
	private LocalDate batchStartDate;
	@Column(name="batch_status")
	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;
	@Column(name="batch_technology")
	@Enumerated(EnumType.STRING)
	private BatchTechnology batchTechnology;
	
//	@Column(name="batch_mentor_mentor_id")
//	private String batchMentorMentorId;
	@OneToOne
	private Mentor batchMentor;
}
