package com.sunbeam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sunbeam.dao.Parts_DAO;
import com.sunbeam.entities.Part_Entity;
import com.sunbeam.entities.Serviceparts;

public class Part_Service {
	
	//Retrieves and displays all parts information.
	public static List<Part_Entity> showAll() {
		System.out.println("Showing All parts info::");
		List<Part_Entity> partList = new ArrayList<>();
		Parts_DAO partDAO = new Parts_DAO();
		partDAO.ShowAll(partList);
		partList.forEach(System.out::println);
		return partList;
	}
	
	//Displays a specific part based on the given ID.
	public static Part_Entity SpeciShow() {
		System.out.println("Enter Id of Part to display::");
		int id = getInputId();
		return com.sunbeam.dao.Parts_DAO.SpeciShow(id);
		
	}
	
	//Inserts part data into the database.
	public static void insertToDB() {
		System.out.println("Enter Part Name::");
		String name = getInputString();
		System.out.println("Enter Description::");
		String description = getInputString();
		System.out.println("Enter Price::");
		double price = getInputDouble();

		Part_Entity parts = new Part_Entity(name,description,price);

		com.sunbeam.dao.Parts_DAO.insertToDB(parts);
		System.out.println("Data Inserted Successfully");
	}
	
	//Updates the price of a specific part based on the given ID.
	public static void update() {
		Part_Service.showAll();
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
	
	public Part_Entity getPart(int partId, Part_Entity part) {
	    // Code to retrieve part details from the database based on the partId
	    
	   
	    part.setId(part.getId());
	    part.setName(part.getName());
	    part.setPrice(part.getPrice());
		return part;
	    
	    
	    
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
    public static Map<Part_Entity, Integer> getAllServiceParts(List<Serviceparts> partsList) {
		List<Part_Entity> allParts = showAll();
		Map<Part_Entity, Integer> servicePartsList = new HashMap<Part_Entity, Integer>();
		for (Serviceparts serviceparts : partsList) {
			Part_Entity part=new Part_Entity(serviceparts.getPartid());
			
		}
		return servicePartsList;
    }
	}


