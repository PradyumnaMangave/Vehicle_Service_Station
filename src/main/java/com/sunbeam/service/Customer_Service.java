package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Customer_DAO;
import com.sunbeam.entities.Customer_Entity;

public class Customer_Service {

	//Inserts customer data into the database.
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
	
	//Deletes a customer from the database based on the given ID.
	public static void delete() {
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
	
	//Retrieves and displays all customers from the database.
	public static List<Customer_Entity> showAll() {
		System.out.println("Showing All customers");
		List<Customer_Entity> customerList = new ArrayList<>();
		Customer_DAO custDAO = new Customer_DAO();
		custDAO.ShowAll(customerList);
		for (Customer_Entity customer_Entity : customerList) {
			System.out.println(customer_Entity);
			
		}
		//return the list of customers
		return customerList;
		
	}
	
	//Displays a specific customer based on the given ID.
	public static Customer_Entity speciShow() {
	    System.out.println("Enter Specific Customer's ID:");
	    int selectedCustomerId = new Scanner(System.in).nextInt();
	    
	    Customer_Entity customer = com.sunbeam.dao.Customer_DAO.getCustomerById(selectedCustomerId);
	    if(customer == null)
	    com.sunbeam.service.Customer_Service.insertToDB();
		return customer;
	    
	}
	
	//Displays a specific customer based on the given mobile number.
	public static Customer_Entity speciShow1() {
		System.out.println("Enter Customer's Mobile Number::");
		String mobile =new Scanner(System.in).next();
		Customer_Entity customer = com.sunbeam.dao.Customer_DAO.SpeciShow(mobile);
		return customer;
	}
	
	//Updates customer data in the database.
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
