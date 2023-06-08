package com.sunbeam.Menu;

import java.util.Scanner;

public class MenuOptions {

	public static int MainMenuOptions() {
		
		System.out.println("0. Exit");
		System.out.println("1. Customer Info");
		System.out.println("2. Vehicle Info");
		System.out.println("3. Service Request");
		System.out.println("4. Part Info");
		System.out.println("5. Todays Business");
		System.out.println("6. Given Date Business");
		System.out.print("Enter Your choice = ");
		return new Scanner(System.in).nextInt();
		}
	
	public static int CustomerOptions() {
		System.out.println("Customer Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Customer");
		System.out.println("2. Edit Customer");
		System.out.println("3. Delete Customer");
		System.out.println("4. Show All Customers");
		System.out.println("5. Show Specific Customer");
		System.out.print("Enter Your choice = ");
		return new Scanner(System.in).nextInt();
		
	}
	
	public static int ServiceRequestOptions() {
		System.out.println("Service Request Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Select Customer Menu");
		System.out.println("2. Process Request Menu");
		System.out.println("3. Display Bill");
		System.out.println("4. Get Payment From customer");
		return new Scanner(System.in).nextInt();
	}
	
	public static int ServiceReqSubMenuCustomer() {
		System.out.println("Customer Submenu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Choose Existing Customer");
		System.out.println("2. Display His/Her vehicles");
		System.out.println("3. Choose vehicle from vehicle list");
		return new Scanner(System.in).nextInt();
		
	}
	
	public static int ServiceReqSubMenuProcessReq() {
		System.out.println("Process Request Submenus");
		System.out.println("0. Previous Menu");
		System.out.println("1. New Service");
		System.out.println("2. Existing Service");
		System.out.println("3. Maintainence");
		System.out.println("4. Repairing");
		System.out.println("5. Oil/Additive change/add");
		return new Scanner(System.in).nextInt();
		
	}
	
	public static int VehicleOptions() {
		System.out.println("Vehicle Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Vehicle");
		System.out.println("2. Edit Vehicle Info");
		System.out.println("3. Delete Vehicle");
		System.out.println("4. Show All Vehicles");
		System.out.println("5. Show Specific Vehicle");
		System.out.print("Enter Your choice = ");
		return new Scanner(System.in).nextInt();
	}

	public static int PartOptions() {
		System.out.println("Parts menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Part");
		System.out.println("2. Edit Part Info");
		System.out.println("3. Delete part");
		System.out.println("4. Show All Parts");
		System.out.println("5. Show Specific Part");
		return new Scanner(System.in).nextInt();
	}
}
