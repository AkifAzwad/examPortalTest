
package com.exam.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.exam.model.courses.Batch;
import com.exam.model.courses.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "username shouldn't be null")
	private String username;
	@NotNull(message = "password shouldn't be null")
	private String password;
	private String fName;
	private String lName;
	@Email(message = "invalid email address")
	private String email;
//	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String phone;
	private boolean enabled = true;
	private String profile;
	@ManyToMany(targetEntity = Role.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
//	@JsonIgnore
//	@JsonManagedReference
	@JsonIgnoreProperties("users")
	private Set<Role> userRoles = new HashSet<>();

	@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("users")
	private Set<Course> courses = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("users")
	private Batch batch;

	public User(Long id, String userName, String password, String fName, String lName, String email, String phone,
			boolean enabled) {
		this.id = id;
		this.username = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole -> {
			set.add(new Authority(userRole.getRoleName()));
		});
		return set;
	}

//	@Override
//	public String getUsername() {
//		return this.username;
//		
//	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
