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
		
		
	}
	
	private static void service_request() {
		
		
	}
	
	private static void partMenu() {
		
		
	}
	
	private static void todays_business() {
		
		
	}
	
	private static void Specific_Day_business() {
		
		
	}
}
