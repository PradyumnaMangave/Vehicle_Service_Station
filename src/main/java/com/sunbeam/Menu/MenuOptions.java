package com.sunbeam.Menu;

import java.util.Scanner;

public class MenuOptions {

	public static int MainMenuOptions() {
		
		System.out.println("0. Exit");
		System.out.println("1. Customer Info");
		System.out.println("2. Vehicle Info");
		System.out.println("3. Service Request");
		System.out.println("4. Part Info");
		System.out.println("5. Todays Business");
		System.out.println("6. Given Date Business");
		return new Scanner(System.in).nextInt();
		}
	
	public static int CustomerOptions() {
		System.out.println("Customer Menu");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Customer");
		System.out.println("2. Edit Customer");
		System.out.println("3. Delete Customer");
		System.out.println("4. Show All Customers");
		System.out.println("5. Show Specific Customer");
		System.out.print("Enter Your choice = ");
		return new Scanner(System.in).nextInt();
		
	}
}
