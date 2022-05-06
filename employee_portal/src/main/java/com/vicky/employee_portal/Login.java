package com.vicky.employee_portal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Login {
	static Scanner sc = new Scanner(System.in);

	static void login() {
		System.out.println("Enter your Employee ID");
		int emp_id = sc.nextInt();
		System.out.println("Enter your Password");
		String emp_password = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		
		try {

			Employee_Info info = manager.find(Employee_Info.class, emp_id);
			int id = info.getEmployee_ID();
			String pass = info.getPassword();
			if (emp_password.equals(pass) && emp_id == id) {
				System.out.println("Successfully Logged in");
				if(info.getEmployee_Type().contentEquals("manager")) {
					 Manager manage = new Manager();
					 manage.manager_screen(info);
				}
				else{
					Employee employee = new Employee();
					employee.employee_screen(info);
				}
			} else if (emp_id == id) {
				System.out.println("Wrong password");
			} else {
				System.out.println("User Record Not found");
			}
		
			
		} catch (NullPointerException e) {
			System.out.println("Invalid User\nTry to register");
		}
	}
}
