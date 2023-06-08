package com.sunbeam.Menu;

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
