package com.te.lms.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="batch_batch_strength")
public class BatchStrength {
	@Column(name = "batch_strength")
	private Integer batchStrength;

	@Id
	@Column(name = "batch_strength_key")
	private Integer batchStrengtKey;
	@OneToOne
	private Batch batch;

}
