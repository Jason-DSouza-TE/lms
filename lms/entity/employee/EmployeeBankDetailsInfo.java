package com.te.lms.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.te.lms.enums.AccountType;
import com.te.lms.enums.BankName;

import lombok.Data;
@Data
@Entity
@Table(name="employee_bank_details_info")
public class EmployeeBankDetailsInfo {
	@Id
	@Column(name="account_no")
	private Long accountNo ;
	@Column(name="account_type")
	@Enumerated(EnumType.STRING)
	private AccountType  accountType;
	@Column(name="bank_name")
	@Enumerated(EnumType.STRING)
	private BankName bankName ;
	@Column(name="bank_branch")
	private String bankBranch ;
	@Column(name="bank_ifsc")
	private String bankIfsc ;
	@Column(name="state")
	private String state ;
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private EmployeePrimaryInfo
	 * employeePrimaryInfo3;
	 */
}
