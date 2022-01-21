package com.sprinboot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Users")
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public User(String firstName, String surname, String email, String password, Long pincode, Date dob,
			Date joiningdate) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.pincode = pincode;
		// this.roles = roles;
		this.dob = dob;
		this.joiningdate = joiningdate;
		this.deleted = false;
	}

	@NotNull
	private String firstName;

	@NotNull
	private String surname;

	@NotNull
	private long pincode;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy", timezone = "GMT+8")
	private Date joiningdate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy", timezone = "GMT+8")
	private Date dob;

	@NotNull
	private String email;

	@NotNull
	private String password;

	@NotNull
	private boolean deleted;
}
