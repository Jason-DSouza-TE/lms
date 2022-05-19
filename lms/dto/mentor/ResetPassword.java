package com.te.lms.dto.mentor;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResetPassword {
	private String id;
	private String oldPass;
	private String newPass;
	private String confirmPass;
}
