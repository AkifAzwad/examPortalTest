package com.exam.model.courses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.exam.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long batchId;
	@NotNull(message = "batch name shouldn't be null")
	private String batchname;
	private String batchdesc;
	@OneToMany(mappedBy = "batch",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("batch")
	private Set<User> users = new HashSet<>();
}
