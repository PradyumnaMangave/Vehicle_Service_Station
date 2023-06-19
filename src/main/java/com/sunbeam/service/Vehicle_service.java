	package com.sunbeam.service;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	
	import com.sunbeam.dao.Vehicle_DAO;
	import com.sunbeam.entities.Customer_Entity;
	import com.sunbeam.entities.NewVehicleEntity;
	import com.sunbeam.entities.Vehicle_Entity;
	
	public class Vehicle_service {
		
		private static Scanner scanner = new Scanner(System.in);
		private static Vehicle_DAO vehicleDAO = new Vehicle_DAO();
		private static List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity>();
		
		//Insert new vehicle number into the database
		public static void insertToDb() {
			Customer_Entity customer = Customer_Service.speciShow1();	
			if(customer != null) {
				 System.out.println("Enter vehicle Number::");
				 String vehicle_number = readStringInput().toUpperCase();
			
				 try {
					 List<Vehicle_Entity> vehicle_list = vehicleDAO.getData();
					 for (Vehicle_Entity vehicle_Entity : vehicle_list) {
						 System.out.println(vehicle_Entity);
						 }
					 System.out.println("Choose vehicle from Vehicle list");
					 System.out.println("Enter 0 to Add vehicle");
					 System.out.println("Enter 1 to Use Existing vehicle");
					 int choice = new Scanner(System.in).nextInt();
					 if(choice == 0) {
						 Vehicle_service.vehicle_add();
					 }
					 else if(choice==1){
						 System.out.println("Choose Vehicle ID::");
						 int vehicle_id = new Scanner(System.in).nextInt();
						 vehicleDAO.EnterIntoVehicle(vehicle_number,customer.getId(),vehicle_id);
						 System.out.println("Vehicle added into Database....");
					 }	 
					 else {
						 System.out.println("Choose Correct Option...");
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
		
		//Add a new vehicle to the database
		public static int vehicle_add() {
			System.out.println("Enter ID::");
			int id = readIntInput();
			System.out.println("Enter Company Name of Vehicle::");
			String company = readStringInput(); 
			System.out.println("Enter Model Name of Vehicle::");
			String model = readStringInput(); 
			Vehicle_Entity vehicle_Entity = new Vehicle_Entity(id, company, model);
			com.sunbeam.dao.Vehicle_DAO.insertToDB(vehicle_Entity);
			System.out.println("Data Inserted Successfully");
			return id;
			
		}
		
		// Get specific customer details and their vehicles
		public static void speciCustomer() {
			Customer_Entity customer = Customer_Service.speciShow1();
			
		    vehicleDAO.speciCustomer(vehicleList,customer);
		    if(vehicleList!=null)
		    for (NewVehicleEntity newVehicleEntity : vehicleList) {
				System.out.println(newVehicleEntity);
			}
		    else {
		    	Customer_Service.insertToDB();
		    }
		}
		
		//Show details of all vehicles
		public static void showAll() {
			Customer_Entity customer = null;
		    vehicleDAO.ShowAll(vehicleList,customer);
		    
		    for (NewVehicleEntity newVehicleEntity : vehicleList) {
				System.out.println(newVehicleEntity);
			}
			
		}
		
		//Update a vehicle's details
		public static void update() {
			Customer_Entity customer=null;
			System.out.println("Enter vehicle number you want to update::");
			String Old_Vehicle_Number =readStringInput();
		    vehicleDAO.speciCustomerByVehiNum(vehicleList,customer, Old_Vehicle_Number);
		    
		    for (NewVehicleEntity newVehicleEntity : vehicleList) {
				System.out.println(newVehicleEntity);
			}
			
			
			if(Vehicle_DAO.searchNumber(Old_Vehicle_Number)) 
			{
				System.out.println("Enter new Vehicle number you want to update::");
				String New_Vehicle_Number = readStringInput();
				Vehicle_DAO.update_Number(Old_Vehicle_Number,New_Vehicle_Number);
				System.out.println("Vehicle Number Updated Successfully...");
				}
			else {
				System.out.println("Customer not found...");
			}
		}
		
		// Delete a vehicle from the database
		public static void delete() {
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
		
		// Helper method to read an integer input from the user
		private static int readIntInput() {
	        return scanner.nextInt();
	    }

	    // Helper method to read a string input from the user
	    private static String readStringInput() {
	        return scanner.next();
	    }
	}
