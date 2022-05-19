package com.te.lms.dto.admin;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.te.lms.enums.BatchStatus;
import com.te.lms.enums.BatchTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AddBatchDto {
	private String mentorId;
	private String batchId;
	private LocalDate batchEndDate;
	private LocalDate batchStartDate;
	private String batchName;
	private BatchStatus batchStatus;
	private BatchTechnology batchTechnology;
}
