package com.vicky.employee_portal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee_Info {

	@Id
	int Employee_ID;
	@Column(name = "Employee_Name", length=50)
	String Employee_Name;
	@Column(name = "Employee_Type", length=50)
	String Employee_Type;
	@Column(name = "Email", length=100)
	String Email;
	@Column(name = "Password", length=50)
	String Password;
	
	
}
