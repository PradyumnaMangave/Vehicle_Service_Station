package com.sunbeam.Menu;

public class Menu {
	
	public static void mainMenu(){
		EMainMenu choice;
		
			while((choice = MenuOptions.MainMenuOptions()) != EMainMenu.EXIT) {
				switch (choice) {
				case CUSTOMER:
					customerMenu();
					break;
				
				case VEHICLE:
					vehicleMenu();
					break;	
					
				case SERVICE:
					service_request();
					break;
					
				case PART:
					partMenu();
					break;
					
				case TODAYBUSINESS:
					todays_business();
					break;
					
				case SPECIBUSINESS:
					Specific_Day_business();
					break;

				default:
					System.out.println("Wrong choice selected...");
					break;
				}
			
		} 
	}

	private static void customerMenu() {
		ECustomerMenu choice;
		while((choice = MenuOptions.CustomerOptions()) != ECustomerMenu.EXIT) {
			switch (choice) {
			case ADD:
				com.sunbeam.service.Customer_Service.insertToDB();
				break;
				
			case EDIT:
				System.out.println("Update customer");
				break;
				
			case DELETE:
				com.sunbeam.service.Customer_Service.Delete();
				break;
				
			case ALL:
				com.sunbeam.service.Customer_Service.ShowAll();
				break;
				
			case SPECI_SHOW:
				com.sunbeam.service.Customer_Service.SpeciShow();
				break;
				
			default:
				System.out.println("Wrong Choice Selected");
				break;
			}
		}
	}
	
	private static void vehicleMenu() {
		EVehicleMenu choice;
		while((choice = MenuOptions.VehicleOptions()) != EVehicleMenu.EXIT) {
			switch (choice) {
			case ADD:
				System.out.println("Add Vehicle");
				break;
				
			case EDIT:
				System.out.println("Update Vehicle");
				break;
				
			case DELETE:
				System.out.println("Delete Vehicle");
				break;
				
			case ALL:
				System.out.println("Show all Vehicles");
				break;
				
			case SPECI_SHOW:
				System.out.println("Show Specific Vehicles");
				break;
				
			default:
				System.out.println("Wrong choice selected...");
				break;
			}
		}	
	}
	
	private static void service_request() {
		EServiceRequestMenu choice;
		while((choice = MenuOptions.ServiceRequestOptions()) != EServiceRequestMenu.EXIT) {
			switch (choice) {
			case SELECT_CUSTOMER:
				System.out.println("Select from below options::");
				Service_Req_Customer_SubMenu();
				
				break;
				
			case PROCESS_REQUEST:
				System.out.println("Select from process request submenu");
				Service_Req_Sub_Process_Request();
				break;
				
			case DISPLAY_BILL:
				System.out.println("Generate bill");
				break;
				
			case GET_PAYMENT:
				System.out.println("Get payment from customer and store it in table");
				break;
				
			default:
				System.out.println("Wrong Choice Selected..");
				break;
			}
		}
	}
	
	private static void Service_Req_Customer_SubMenu() {
		EServiceRequestSubCustomer choice;
		while((choice = MenuOptions.ServiceReqSubMenuCustomer()) != EServiceRequestSubCustomer.EXIT) {
			switch (choice) {
			case CHOOSE_CUSTOMER:
				System.out.println("Choose customer");
				break;

			case DISPLAY_HIS_VEHICLES:
				System.out.println("Display vehicle data");
				break;

			case CHOOSE_VEHICLE:
				System.out.println("Choose vehicle");
				break;

			default:
				System.out.println("Wrong Choice Selected");
				break;
			}
		}
	}
	
	private static void Service_Req_Sub_Process_Request() {
		EServiceRequestSubProcess choice;
		while((choice = MenuOptions.ServiceReqSubMenuProcessReq()) != EServiceRequestSubProcess.EXIT) {
			switch (choice) {
			case NEW_SERVICE:
				System.out.println("New Service");
				break;

			case EXISTING_SERVICE:
				System.out.println("existing service");
				break;

			case MAINTAINANCE:
				System.out.println("maintainence");
				break;

			case REPAIRING:
				System.out.println("repairing");
				break;

			case OIL_ADDITIVE_CHANGE:
				System.out.println("Oil/additive change if any");
				break;

			default:
				System.out.println("Wrong Choice selected");
				break;
			}
		}
	}
	
	private static void partMenu() {
		EPartsMenu choice;
		while ((choice = MenuOptions.PartOptions()) != EPartsMenu.EXIT){
			switch (choice) {
			case ADD:
				System.out.println("Add");
				break;
				
			case EDIT:
				System.out.println("Update");
				break;
				
			case DELETE:
				System.out.println("Delete");
				break;
				
			case ALL:
				System.out.println("Show all");
				break;
				
			case SPECI_SHOW:
				System.out.println("Show specific");
				break;

			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	
	}
	
	private static void todays_business() {
		
		
	}
	
	private static void Specific_Day_business() {
		
		
	}
}
