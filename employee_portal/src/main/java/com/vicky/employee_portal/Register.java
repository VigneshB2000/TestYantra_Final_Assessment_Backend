package com.vicky.employee_portal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Register {

	static Scanner sc = new Scanner(System.in);

	static void register() {
		Employee_Info employee_Info = new Employee_Info();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("Select count(*) from Employee_Info");
		Object emp_count =query.getSingleResult();
		
		employee_Info.setEmployee_ID(Integer.parseInt(emp_count.toString())+1);
		
		System.out.println("Enter your Name");
		employee_Info.setEmployee_Name(sc.next());

		System.out.println("Enter Employee Type: \n•	Press 1 for Manager\n•	Press 2 for Employee\n ");
		int option = sc.nextInt();
		if (option == 1) {
			employee_Info.setEmployee_Type("manager");
		} else {
			employee_Info.setEmployee_Type("employee");
		}

		System.out.println("Enter your mail id");
		employee_Info.setEmail(sc.next());

		System.out.println("Enter your password");
		employee_Info.setPassword(sc.next());

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee_Info);
		transaction.commit();

		System.out.println("Details Registered Successfully");
	}
}
