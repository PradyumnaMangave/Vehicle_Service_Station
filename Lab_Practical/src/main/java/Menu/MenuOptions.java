package Menu;

import java.util.Scanner;

enum Emenu{
	EXIT,ADD_NEW_EMPLOYEE,UPDATE_EMPLOYEE,LIST_EMPLOYEE,LIST_DEPARTMENT,DEFAULT;
}

public class MenuOptions {

	public static Emenu MenuOptions() {
		System.out.println("0. Exit");
		System.out.println("1. Add New Employee");
		System.out.println("2. Update Employee Salary");
		System.out.println("3. List Employees");
		System.out.println("4. List Departments");
		System.out.print("Enter Your choice = ");
		int choice = new Scanner(System.in).nextInt();
		if(choice < 0 || choice > 4)
			return Emenu.values()[5];
		else
			return Emenu.values()[choice];
	}
}
