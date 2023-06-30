package Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAO.EmpDAO;

public class EmpService {

public static void insertNewEmp() {
		
		System.out.println("Enter Employee Number::");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Enter Employee Name::");
		String name = new Scanner(System.in).next();
		System.out.println("Enter Employees Job Role::");
		String job = new Scanner(System.in).next();
		System.out.println("Enter Manager ID::");
		int manager = new Scanner(System.in).nextInt();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("Enter hire date (yyyy-MM-dd): ");
        String hireDateString =new Scanner(System.in).next();
        Date hireDate = null;
        
        System.out.println("Enter Employee Salary::");
        double salary = new Scanner(System.in).nextDouble();	
        
        System.out.println("Enter Department Number::");
        int deptNo = new Scanner(System.in).nextInt();
        
        EmpDAO.insertIntoEmployeeTable(id,name,job,manager,hireDate,salary,deptNo);
	}

public static  void updateEmp() {
	try {
		EmpDAO emp = new EmpDAO();
		emp.update();
		System.out.println("Salary Updated...");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

public static void listEmployee() {
	System.out.println("Enter year ::");
	String year = new Scanner(System.in).next();
	EmpDAO.listEmp(year);
}
	

   
}
