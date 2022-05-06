package com.vicky.employee_portal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Rough {
public static void main(String[] args) {
	Employee_Info employee_Info = new Employee_Info();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
	EntityManager manager = factory.createEntityManager();
	Query query = manager.createQuery("Select count(*) from Employee_Info");
	System.out.println(query.getSingleResult());
		
}
}
