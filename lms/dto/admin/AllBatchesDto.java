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
@AllArgsConstructor
@NoArgsConstructor
public class AllBatchesDto {
	private String batchId;
	private String batchName;
	private BatchTechnology batchTechnology;
	private LocalDate batchStartDate;
	private BatchStatus batchStatus;
	private LocalDate batchEndDate;
	private String mentorName;
	
}
