package com.sunbeam.service;

import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.Vehicle_Entity;

public class Vehicle_service {
	
	public static void insertToDb() {
		Customer_Entity customer = Customer_Service.SpeciShow1();
		
		 if(customer != null) {
			 System.out.println("Enter vehicle Number::");
			 String vehicle_number = new Scanner(System.in).next().toUpperCase();
		
			 try {
				 Vehicle_DAO vehicle_DAO= new Vehicle_DAO();
				 List<Vehicle_Entity> vehicle_list = vehicle_DAO.getData();
				 for (Vehicle_Entity vehicle_Entity : vehicle_list) {
					 System.out.println(vehicle_Entity);
					 }
				 System.out.println("Choose vehicle");
				 
			
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
}
