package com.te.lms.entity.admin;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {
	@Id
	@Column(name = "mentor_id")
	private String mentorId;
	@Column(name = "mentor_email")
	private String mentorEmail;
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	@Column(name = "mentor_name")
	private String mentorName;
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String username;
//	@Column(name = "first_login")
//	private String firstLogin;
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "mentors")
//	private List<EmployeeTechnicalSkillsInfo> employeeTechnicalSkillsInfos;
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "mentors1")
//    private List<MockDetails> mockDetails;
	@Column(name = "technical_skills")
	private String technicalSkills;
	

}

