package com.exam.model.courses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long topicId;
	@NotNull(message = "topic name shouldn't be null")
	private String topicName;

	private String topicDesc;
}
