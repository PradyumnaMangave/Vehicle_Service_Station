package com.sunbeam.service;

import java.util.Scanner;

import com.sunbeam.entities.Customer_Entity;

public class Customer_Service {

	public static void insertToDB() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Customer data");
		System.out.println("Enter Customer Details: id,name,mobile,email,address");
		Customer_Entity customer = new Customer_Entity(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
		com.sunbeam.dao.Customer_DAO.insertToDB(customer);
	}
}
