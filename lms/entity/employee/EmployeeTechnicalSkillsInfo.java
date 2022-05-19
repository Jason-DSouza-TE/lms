package com.te.lms.entity.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "employee_technical_skills_info")
public class EmployeeTechnicalSkillsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Integer skillId;
	@Column(name = "skill_rating")
	private Integer skillRating;
	@Column(name = "skill_type")
	private String skillType;
	@Column(name = "year_of_experience_on_skill")
	private Integer yearOfExperienceOnSkill;

	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "mentor_technical_skills", 
//	joinColumns = @JoinColumn(name = "technical_skills_skill_id"), 
//	inverseJoinColumns = @JoinColumn(name = "mentor_mentor_id"))
//	private List<Mentor> mentors;
	
	

//	M-M with primary 2way

}
