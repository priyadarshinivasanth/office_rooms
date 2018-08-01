package com.example.demo.model.copy;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class Login {
	@Id
	private int id;
	
	@NotBlank
	public String name;
	
	public char gender;
	
	@Column(name="email")
	public String em;
	
	@Column(name="password")
	public String pass;
	
	@Temporal(TemporalType.DATE)
	public Date dob;

}
