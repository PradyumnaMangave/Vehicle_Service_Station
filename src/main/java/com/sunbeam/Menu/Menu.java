package com.sunbeam.Menu;

import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.service.Service_req_service;

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
				com.sunbeam.service.Customer_Service.update();
				break;
				
			case DELETE:
				com.sunbeam.service.Customer_Service.delete();
				break;
				
			case ALL:
				com.sunbeam.service.Customer_Service.showAll();
				break;
				
			case SPECI_SHOW:
				com.sunbeam.service.Customer_Service.speciShow();
				break;
				
			case SPECI_SHOW_MOBILE:
				System.out.println(com.sunbeam.service.Customer_Service.speciShow1()); 
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
				com.sunbeam.service.Vehicle_service.insertToDb();
				break;
				
			case EDIT:
				com.sunbeam.service.Vehicle_service.update();;
				break;
				
			case DELETE:
				com.sunbeam.service.Vehicle_service.delete();
				break;
				
			case ALL:
				com.sunbeam.service.Vehicle_service.showAll();
				break;
				
			case SPECI_SHOW:
				com.sunbeam.service.Vehicle_service.speciCustomer();
				break;
				
			default:
				System.out.println("Wrong choice selected...");
				break;
			}
		}	
	}
	
	private static void service_request() {
		EServiceRequestMenu choice;
		String vehicleNumber = null;
		while((choice = MenuOptions.ServiceRequestOptions()) != EServiceRequestMenu.EXIT) {
			switch (choice) {
			case SELECT_CUSTOMER:
				
				vehicleNumber = com.sunbeam.service.Service_req_service.chooseCustomer();
				
				break;
				
			case PROCESS_REQUEST:
				if (vehicleNumber != null) {
				System.out.println("Select from process request submenu");
				Service_Req_Sub_Process_Request(vehicleNumber);
				}
				else {
					System.out.println("Select Vehicle First...");
				}
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
	
	private static void Service_Req_Sub_Process_Request(String vehicleNumber) {
		EServiceRequestSubProcess choice;
		while((choice = MenuOptions.ServiceReqSubMenuProcessReq()) != EServiceRequestSubProcess.EXIT) {
			ServiceRequestEntity ServiceRequest = null;
			switch (choice) {
			case NEW_SERVICE:
				
				ServiceRequest = Service_req_service.createNewService(vehicleNumber);

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
				com.sunbeam.service.Part_Service.insertToDB();
				break;
				
			case EDIT:
				com.sunbeam.service.Part_Service.update();
				break;
				
			case DELETE:
				com.sunbeam.service.Part_Service.delete();
				break;
				
			case ALL:
				com.sunbeam.service.Part_Service.showAll();
				break;
				
			case SPECI_SHOW:
				com.sunbeam.service.Part_Service.SpeciShow();
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
