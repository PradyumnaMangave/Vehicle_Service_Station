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
				com.sunbeam.service.Vehicle_service.Update();;
				break;
				
			case DELETE:
				com.sunbeam.service.Vehicle_service.Delete();
				break;
				
			case ALL:
				com.sunbeam.service.Vehicle_service.ShowAll();
				break;
				
			case SPECI_SHOW:
				com.sunbeam.service.Vehicle_service.SpeciCustomer();
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
				com.sunbeam.service.Service_req_service.chooseCustomer();
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
