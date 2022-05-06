package com.vicky.employee_portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee_Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int S_No;
	@JoinColumn(name = "Employee_ID")
	int Employee_ID;
	@Column(name = "Leave_Date", length=50)
	String Leave_Date;
	@Column(name = "Leave_Status", length=50)
	String Leave_Status;
	@Override
	public String toString() {
		return "\nEmployee_Leave [Leave_Date=" + Leave_Date + ", Leave_Status=" + Leave_Status + "]";
	}
	
	
	
}
