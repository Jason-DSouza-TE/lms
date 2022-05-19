package com.te.lms.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "admin_id")
	private String adminId;
	@Column(name = "admin_email")
	private String adminEmail;
	@Column(name = "gender")
	private String gender;
	@Column(name = "is_account_active")
	private Integer isAccountActive;
	@Column(name = "admin_name")
	private String adminName;
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String userName;

}
