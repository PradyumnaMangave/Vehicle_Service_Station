package Menu;

import Service.DeptService;
import Service.EmpService;

public class Menu {
	
	public static void mainMenu() {
	Emenu choice;
	while ((choice = MenuOptions.MenuOptions()) != Emenu.EXIT) {
		switch (choice) {
		case ADD_NEW_EMPLOYEE:
			EmpService.insertNewEmp();
			break;

		case UPDATE_EMPLOYEE:
			EmpService.updateEmp();
			break;

		case LIST_EMPLOYEE:
			EmpService.listEmployee();
			break;

		case LIST_DEPARTMENT:
			
			break;

		default:
			System.out.println("Wrong choice selected...");
			break;
		}

	}
	
	
	
	}
	}

