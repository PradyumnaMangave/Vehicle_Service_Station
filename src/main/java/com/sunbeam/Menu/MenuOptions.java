package com.sunbeam.Menu;

import java.util.Scanner;

public class MenuOptions {

	public static int MainMenuOptions() {
		System.out.println("Main Menu");
		System.out.println("1. Customer Info");
		System.out.println("2. Vehicle Info");
		System.out.println("3. Service Request");
		System.out.println("4. Part Info");
		System.out.println("5. Todays Business");
		System.out.println("6. Given Date Business");
		System.out.println("0. Exit");
		return new Scanner(System.in).nextInt();
		
		
	}
}
