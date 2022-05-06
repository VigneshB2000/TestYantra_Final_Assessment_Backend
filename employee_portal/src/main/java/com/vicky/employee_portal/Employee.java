package com.vicky.employee_portal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Employee {

	static Scanner sc = new Scanner(System.in);

	void leave_status(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		try {
			Query query1 = manager.createQuery("from Employee_Leave where Employee_ID =:id").setParameter("id", id);
			List<Employee_Leave> statusid = query1.getResultList();
			System.out.println(statusid);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void leave_request(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Employee_Leave leave = new Employee_Leave();
			leave.setEmployee_ID(id);
			System.out.println("Enter your Leave date in dd/mm/yyyy");
			leave.setLeave_Date(sc.next());
			leave.setLeave_Status("Pending");
			transaction.begin();
			manager.persist(leave);
			transaction.commit();
			System.out.println("Leave Applied Successfully");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void employee_screen(Employee_Info info) {
		boolean status = true;
		while (status) {
			System.out.println("Hello " + info.getEmployee_Name());
			System.out.println("	Press 1 to show all status of leave requests\n"
					+ "	Press 2 to request for a leave\n" + "	Press 3 to go back to Main menu\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				leave_status(info.getEmployee_ID());
				break;
			}
			case 2: {
				leave_request(info.getEmployee_ID());
				break;
			}
			default: {
				System.out.println("please enter a correct option");
				status = false;
				break;
			}
			}

		}
	}
}
