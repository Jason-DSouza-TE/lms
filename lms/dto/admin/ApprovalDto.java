package com.te.lms.dto.admin;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ApprovalDto {
private String empId;
private String empName;
private Integer yearOfPassing;
private String empMail;
private Integer requestId;
private String batchId;
private String batchName;
private Integer isRejected;
private String rejectionReason;


}
