package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Customer_DAO;
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
	
	public static void ShowAll() {
		System.out.println("Showing All customers");
		List<Customer_Entity> customerList = new ArrayList<>();
		Customer_DAO custDAO = new Customer_DAO();
		custDAO.ShowAll(customerList);
		for (Customer_Entity customer_Entity : customerList) {
			System.out.println(customer_Entity);
			
		}
		
	}
	
	public static void SpeciShow() {
	    System.out.println("Enter Specific Customer's ID:");
	    int id = new Scanner(System.in).nextInt();
	    
	    boolean customer = com.sunbeam.dao.Customer_DAO.SpeciShow(id);
	    
	}
	
	public static void update() {
		System.out.println("Enter ID in which You want to update data::");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Add mobile number to update::");
		String mobile = new Scanner(System.in).nextLine();
		System.out.println("Add Address to update");
		String address = new Scanner(System.in).nextLine();
		boolean customer = false;
		
		if (!mobile.isEmpty() && !address.isEmpty()) {
	        customer = com.sunbeam.dao.Customer_DAO.update(id, mobile, address);
	    } else if (!mobile.isEmpty()) {
	        customer = com.sunbeam.dao.Customer_DAO.updateMobile(id, mobile);
	    } else if (!address.isEmpty()) {
	        customer = com.sunbeam.dao.Customer_DAO.updateAddress(id, address);
	    }
		 if (customer) {
		        System.out.println("Customer updated successfully");
		    } else {
		        System.out.println("Failed to update customer");
		    }
	}
}
