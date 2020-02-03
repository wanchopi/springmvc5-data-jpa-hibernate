package com.wanchopi.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;

/**
 * Employee entity
 * 
 * @author Wanchopi
 *
 */
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private long id;
	
	@Column(name = "first_name")
	@NotNull
	@Size(min = 2, max = 50)
	@Getter @Setter
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	@Size(min = 2, max = 50)
	@Getter @Setter
	private String lastName;
	
	@Column(name = "email")
	@NotNull
	@Email
	@Getter @Setter
	private String email;

}







