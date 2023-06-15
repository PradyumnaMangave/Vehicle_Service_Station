package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
import com.sunbeam.entities.Vehicle_Entity;

public class Vehicle_service {
	
	public static void insertToDb() {
		Customer_Entity customer = Customer_Service.SpeciShow1();
		System.out.println("Customer ID for mobile number "+ customer.getMobile() + " is " + customer.getId() + " And Customer Name is " + customer.getName() +"...");
		 if(customer != null) {
			 System.out.println("Enter vehicle Number::");
			 String vehicle_number = new Scanner(System.in).next().toUpperCase();
		
			 try {
				 Vehicle_DAO vehicle_DAO= new Vehicle_DAO();
				 List<Vehicle_Entity> vehicle_list = vehicle_DAO.getData();
				 for (Vehicle_Entity vehicle_Entity : vehicle_list) {
					 System.out.println(vehicle_Entity);
					 }
				 System.out.println("Choose vehicle from Vehicle list");
				 System.out.println("Enter 0 to Add vehicle");
				 System.out.println("Enter 1 to Use Existing vehicle");
				 int choice = new Scanner(System.in).nextInt();
				 if(choice == 0) {
					 vehicle_add();
				 }
				 else {
					 System.out.println("Choose Vehicle ID::");
					 int vehicle_id = new Scanner(System.in).nextInt();
					 vehicle_DAO.EnterIntoVehicle(vehicle_number,customer.getId(),vehicle_id);
					 System.out.println("Vehicle added into Database....");
				 }	 
			
			 } catch (Exception e) {
				 e.printStackTrace();
				 }
			 }
		 else{
			 System.out.println("Customer not found....");
			 System.out.println("Check Again Or Add in Customer Database..");
			 com.sunbeam.service.Customer_Service.insertToDB();
				}
		
	}
	
	public static int vehicle_add() {
		System.out.println("Enter ID::");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Enter Company Name of Vehicle::");
		String company = new Scanner(System.in).next(); 
		System.out.println("Enter Model Name of Vehicle::");
		String moddel = new Scanner(System.in).next(); 
		Vehicle_Entity vehicle_Entity = new Vehicle_Entity(id, company, moddel);
		com.sunbeam.dao.Vehicle_DAO.insertToDB(vehicle_Entity);
		System.out.println("Data Inserted Successfully");
		return id;
		
	}

	public static void SpeciCustomer() {
		Customer_Entity customer = Customer_Service.SpeciShow1();
		System.out.println("Customer ID for mobile number "+ customer.getMobile() + " is " + customer.getId() + " And Customer Name is " + customer.getName() +"...");
		List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity> ();
	    Vehicle_DAO vehicle_DAO = new Vehicle_DAO();
	    vehicle_DAO.speciCustomer(vehicleList,customer);
	    
	    for (NewVehicleEntity newVehicleEntity : vehicleList) {
			System.out.println(newVehicleEntity);
		}
	    
	}
	
	public static void ShowAll() {
		Customer_Entity customer = null;
		List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity> ();
	    Vehicle_DAO vehicle_DAO = new Vehicle_DAO();
	    vehicle_DAO.ShowAll(vehicleList,customer);
	    
	    for (NewVehicleEntity newVehicleEntity : vehicleList) {
			System.out.println(newVehicleEntity);
		}
		
	}
	
	public static void Update() {
		Customer_Entity customer=null;
		System.out.println("Enter vehicle number you want to update::");
		String Old_Vehicle_Number = new Scanner(System.in).next().toUpperCase();
		List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity> ();
	    Vehicle_DAO vehicle_DAO = new Vehicle_DAO();
	    vehicle_DAO.speciCustomerByVehiNum(vehicleList,customer, Old_Vehicle_Number);
	    
	    for (NewVehicleEntity newVehicleEntity : vehicleList) {
			System.out.println(newVehicleEntity);
		}
		
		
		if(Vehicle_DAO.searchNumber(Old_Vehicle_Number)) 
		{
			System.out.println("Enter new Vehicle number you want to update::");
			String New_Vehicle_Number = new Scanner(System.in).next().toUpperCase();
			Vehicle_DAO.update_Number(Old_Vehicle_Number,New_Vehicle_Number);
			System.out.println("Vehicle Number Updated Successfully...");
			}
		else {
			System.out.println("Customer not found...");
		}
	}
	
	public static void Delete() {
		System.out.println("Enter Vehicle Number of Vehicle to delete::");
		String vehicle_number = new Scanner(System.in).next().toUpperCase();
		if(Vehicle_DAO.searchNumber(vehicle_number)) {
			Vehicle_DAO.Delete(vehicle_number);
			System.out.println("Vehicle Deleted Successfully...");
		}
		else {
			System.out.println("Vehicle does not found...Check vehicle number again...");
		}
	}
}
