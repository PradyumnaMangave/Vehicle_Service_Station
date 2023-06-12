package com.sunbeam.service;

import java.util.Scanner;

import com.sunbeam.entities.Vehicle_Entity;

public class Vehicle_service {
	
	public static void insertToDb() {
		System.out.println("Enter ID::");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Enter Company Name of Vehicle::");
		String company = new Scanner(System.in).next(); 
		System.out.println("Enter Model Name of Vehicle::");
		String moddel = new Scanner(System.in).next(); 
		Vehicle_Entity vehicle_Entity = new Vehicle_Entity(id, company, moddel);
		com.sunbeam.dao.Vehicle_DAO.insertToDB(vehicle_Entity);
		System.out.println("Data Inserted Successfully");
		
	}
}
