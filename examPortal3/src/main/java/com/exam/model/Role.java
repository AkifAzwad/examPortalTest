package com.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String roleName;

	@ManyToMany(targetEntity = User.class,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			fetch = FetchType.LAZY, mappedBy = "userRoles")
//    @JsonIgnore
//	@JsonBackReference
	@JsonIgnoreProperties("userRoles")
	private Set<User> users = new HashSet<>();
}
