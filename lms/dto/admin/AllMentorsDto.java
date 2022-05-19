package com.te.lms.dto.admin;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AllMentorsDto {
	private String mentorName;
	private String mentorId;
	private String mentorEmail;
	private String technicalSkills;
}
