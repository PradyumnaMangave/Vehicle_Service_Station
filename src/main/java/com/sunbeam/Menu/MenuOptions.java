package com.sunbeam.Menu;

import java.awt.Choice;
import java.util.Scanner;

enum EMainMenu{
	EXIT,CUSTOMER,VEHICLE,SERVICE,PART,TODAYBUSINESS,SPECIBUSINESS,DEFAULT
}

enum ECustomerMenu{
	EXIT,ADD,EDIT,DELETE,ALL,SPECIADD,DEFAULT
}

enum EVehicleMenu{
	EXIT,ADD,EDIT,DELETE,ALL,SPECIADD,DEFAULT
}

enum EServiceRequestMenu{
	EXIT,SELECT_CUSTOMER,PROCESS_REQUEST,DISPLAY_BILL,GET_PAYMENT,DEFAULT
}

enum EServiceRequestSubCustomer{
	EXIT,CHOOSE_CUSTOMER,DISPLAY_HIS_VEHICLES,CHOOSE_VEHICLE,DEFAULT
}

enum EServiceRequestSubProcess{
	EXIT,NEW_SERVICE,EXISTING_SERVICE,MAINTAINANCE,REPAIRING,OIL_ADDITIVE_CHANGE,DEFAULT
}

enum EPartsMenu{
	EXIT,ADD,SPECIADD,EDIT,DELETE,ALL,DEFAULT

}

public class MenuOptions {

	public static EMainMenu MainMenuOptions() {
		
		System.out.println("0. Exit");
		System.out.println("1. Customer Info");
		System.out.println("2. Vehicle Info");
		System.out.println("3. Service Request");
		System.out.println("4. Part Info");
		System.out.println("5. Todays Business");
		System.out.println("6. Given Date Business");
		System.out.print("Enter Your choice = ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 6)
			return EMainMenu.values()[7];
		else
			return EMainMenu.values()[choice];
	}
		

	
	public static ECustomerMenu CustomerOptions() {
		System.out.println("Customer Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Customer");
		System.out.println("2. Edit Customer");
		System.out.println("3. Delete Customer");
		System.out.println("4. Show All Customers");
		System.out.println("5. Show Specific Customer");
		System.out.print("Enter Your choice:: ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 5)
			return ECustomerMenu.values()[6];
		else
			return ECustomerMenu.values()[choice];
	}
	
	public static EServiceRequestMenu ServiceRequestOptions() {
		System.out.println("Service Request Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Select Customer Menu");
		System.out.println("2. Process Request Menu");
		System.out.println("3. Display Bill");
		System.out.println("4. Get Payment From customer");
		System.out.println("Enter Your choice:: ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 4)
			return EServiceRequestMenu.values()[5];
		else
			return EServiceRequestMenu.values()[choice];
	}
	
	public static EServiceRequestSubCustomer ServiceReqSubMenuCustomer() {
		System.out.println("Customer Submenu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Choose Existing Customer");
		System.out.println("2. Display His/Her vehicles");
		System.out.println("3. Choose vehicle from vehicle list");
		System.out.println("Enter your choice:: ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 3)
			return EServiceRequestSubCustomer.values()[4];
		else
			return EServiceRequestSubCustomer.values()[choice];
	}
	
	public static EServiceRequestSubProcess ServiceReqSubMenuProcessReq() {
		System.out.println("Process Request Submenus");
		System.out.println("0. Previous Menu");
		System.out.println("1. New Service");
		System.out.println("2. Existing Service");
		System.out.println("3. Maintainence");
		System.out.println("4. Repairing");
		System.out.println("5. Oil/Additive change/add");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 5)
			return EServiceRequestSubProcess.values()[6];
		else
			return EServiceRequestSubProcess.values()[choice];
		
	}
	
	public static EVehicleMenu VehicleOptions() {
		System.out.println("Vehicle Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Vehicle");
		System.out.println("2. Edit Vehicle Info");
		System.out.println("3. Delete Vehicle");
		System.out.println("4. Show All Vehicles");
		System.out.println("5. Show Specific Vehicle");
		System.out.print("Enter Your choice = ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 5)
			return EVehicleMenu.values()[6];
		else
			return EVehicleMenu.values()[choice];
	}

	public static EPartsMenu PartOptions() {
		System.out.println("Parts menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Part");
		System.out.println("2. Edit Part Info");
		System.out.println("3. Delete part");
		System.out.println("4. Show All Parts");
		System.out.println("5. Show Specific Part");
		System.out.println("Enter Your choice::");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 5)
			return EPartsMenu.values()[6];
		else
			return EPartsMenu.values()[choice];
	}
}
