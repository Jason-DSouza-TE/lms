package com.te.lms.dto.mentor;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
	private LocalDate attendanceDate;
	private Integer attendenceMorning;
	private Integer attendanceNoon;
	private String empId;
}
