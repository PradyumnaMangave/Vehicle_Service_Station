package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Parts_DAO;
import com.sunbeam.entities.Part_Entity;

public class Part_Service {
	
	//Retrieves and displays all parts information.
	public static void showAll() {
		System.out.println("Showing All parts info::");
		List<Part_Entity> partList = new ArrayList<>();
		Parts_DAO partDAO = new Parts_DAO();
		partDAO.ShowAll(partList);
		partList.forEach(System.out::println);
	}
	
	//Displays a specific part based on the given ID.
	public static Part_Entity SpeciShow() {
		System.out.println("Enter Id of Part to display::");
		int id = getInputId();
		return com.sunbeam.dao.Parts_DAO.SpeciShow(id);
		
	}
	
	//Inserts part data into the database.
	public static void insertToDB() {
		System.out.println("Enter ID::");
		int id = getInputId();
		System.out.println("Enter Part Name::");
		String name = getInputString();
		System.out.println("Enter Description::");
		String description = getInputString();
		System.out.println("Enter Price::");
		double price = getInputDouble();

		Part_Entity parts = new Part_Entity(id,name,description,price);

		com.sunbeam.dao.Parts_DAO.insertToDB(parts);
		System.out.println("Data Inserted Successfully");
	}
	
	//Updates the price of a specific part based on the given ID.
	public static void update() {
		System.out.println("Enter Id of Part to update::");
		int id = getInputId();
		System.out.println("Enter price to update::");
		double price = getInputDouble();
		
		boolean parts=com.sunbeam.dao.Parts_DAO.Update(id, price);
		 if (parts) {
		        System.out.println("Customer updated successfully");
		    } else {
		        System.out.println("Failed to update customer");
		    }
		}
	
	//Deletes a part from the database based on the given ID.
	public static void delete() {
		System.out.println("Enter ID of part to delete::");
		int id = getInputId();
		boolean parts=com.sunbeam.dao.Parts_DAO.delete(id);
		if (parts) {
	        System.out.println("Customer Deleted successfully");
	    } else {
	        System.out.println("Failed to delete customer");
	    }
	}
	
	// Helper methods to get user input
    private static int getInputId() {
        return new Scanner(System.in).nextInt();
    }

    private static String getInputString() {
        return new Scanner(System.in).nextLine();
    }

    private static double getInputDouble() {
        return new Scanner(System.in).nextDouble();
    }

	}


