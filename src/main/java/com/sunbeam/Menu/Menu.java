package com.sunbeam.Menu;import javax.swing.colorchooser.ColorChooserComponentFactory;

public class Menu {
	
	public static void mainMenu(){
		int choice;
		
			while((choice = MenuOptions.MainMenuOptions()) != 0) {
				switch (choice) {
				case 1:
					customerMenu();
					break;
				
				case 2:
					vehicleMenu();
					break;	
					
				case 3:
					service_request();
					break;
					
				case 4:
					partMenu();
					break;
					
				case 5:
					todays_business();
					break;
					
				case 6:
					Specific_Day_business();
					break;

				default:
					break;
				}
			
		} 
	}

	private static void customerMenu() {
		int choice;
		while((choice = MenuOptions.CustomerOptions()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("Add customer");
				break;
				
			case 2:
				System.out.println("Update customer");
				break;
				
			case 3:
				System.out.println("Delete customer");
				break;
				
			case 4:
				System.out.println("Show all customer");
				break;
				
			case 5:
				System.out.println("Show Specific Customer");
				break;
				
			default:
				break;
			}
		}
	}
	
	private static void vehicleMenu() {
		int choice;
		while((choice = MenuOptions.VehicleOptions()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("Add Vehicle");
				break;
				
			case 2:
				System.out.println("Update Vehicle");
				break;
				
			case 3:
				System.out.println("Delete Vehicle");
				break;
				
			case 4:
				System.out.println("Show all Vehicles");
				break;
				
			case 5:
				System.out.println("Show Specific Vehicles");
				break;
				
			default:
				break;
			}
		}	
	}
	
	private static void service_request() {
		int choice;
		while((choice = MenuOptions.ServiceRequestOptions()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("Select from below options::");
				Service_Req_Customer_SubMenu();
				
				break;
				
			case 2:
				System.out.println("Select from process request submenu");
				Service_Req_Sub_Process_Request();
				break;
				
			case 3:
				System.out.println("Generate bill");
				break;
				
			case 4:
				System.out.println("Get payment from customer and store it in table");
				break;
				
			default:
				System.out.println("Wrong Choice Selected..");
				break;
			}
		}
	}
	
	private static void Service_Req_Customer_SubMenu() {
		int choice;
		while((choice = MenuOptions.ServiceReqSubMenuCustomer()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("Choose customer");
				break;

			case 2:
				System.out.println("Display vihicle data");
				break;

			case 3:
				System.out.println("Choose vehicle");
				break;

			default:
				System.out.println("Wrong Choice Selected");
				break;
			}
		}
	}
	
	private static void Service_Req_Sub_Process_Request() {
		int choice;
		while((choice = MenuOptions.ServiceReqSubMenuProcessReq()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("New Service");
				break;

			case 2:
				System.out.println("existing service");
				break;

			case 3:
				System.out.println("maintainence");
				break;

			case 4:
				System.out.println("repairing");
				break;

			case 5:
				System.out.println("Oil/additive change if any");
				break;

			default:
				System.out.println("Wrong Choice selected");
				break;
			}
		}
	}
	
	private static void partMenu() {
		int choice;
		while ((choice = MenuOptions.PartOptions()) != 0){
			switch (choice) {
			case 1:
				System.out.println("Add");
				break;
				
			case 2:
				System.out.println("Update");
				break;
				
			case 3:
				System.out.println("Delete");
				break;
				
			case 4:
				System.out.println("Show all");
				break;
				
			case 5:
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
