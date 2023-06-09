package com.sunbeam.service;

import java.util.Scanner;

import com.sunbeam.entities.Customer_Entity;

public class Customer_Service {

	public static void insertToDB() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID::");
		int id = sc.nextInt();
		System.out.println("Enter Customer Name::");
		String name = sc.next();
		System.out.println("Enter Mobile Number::");
		String mobile = sc.next();
		System.out.println("Enter Email Address::");
		String email = sc.next();
		System.out.println("Enter Address::");
		String address = sc.next();
		Customer_Entity customer = new Customer_Entity(id,name,mobile,email,address);

		com.sunbeam.dao.Customer_DAO.insertToDB(customer);
		System.out.println("Data Inserted Successfully");
	}
	
	public static void Delete() {
		System.out.println("Enter Id to delete::");
		Scanner sc = new Scanner(System.in); 
		int id = sc.nextInt();
		boolean f = com.sunbeam.dao.Customer_DAO.Delete(id);
		if (f)
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("Check ID again..");
		}
	}
}
