package com.te.lms.dto.admin;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.te.lms.enums.EmpGender;
import com.te.lms.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SearchById {
private String id;
private String name;
private String empDesignation;
private EmpGender empGender;
private Status empStatus;
private String skills;
private String email;
}
