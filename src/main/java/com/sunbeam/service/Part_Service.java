package com.sunbeam.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Customer_DAO;
import com.sunbeam.dao.Parts_DAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.Part_Entity;

public class Part_Service {
		
	public static void ShowAll() {
		System.out.println("Showing All parts info::");
		List<Part_Entity> partList = new ArrayList<>();
		Parts_DAO partDAO = new Parts_DAO();
		partDAO.ShowAll(partList);
		for (Part_Entity part_Entity : partList) {
			System.out.println(part_Entity);
		}
	}
	
	public static void SpeciShow() {
		System.out.println("Enter Id of Part to display::");
		int id = new Scanner(System.in).nextInt();
		
		boolean part = com.sunbeam.dao.Parts_DAO.SpeciShow(id);
	}
	
	public static void insertToDB() {
		System.out.println("Enter ID::");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Enter Part Name::");
		String name = new Scanner(System.in).next();
		System.out.println("Enter Description::");
		String description = new Scanner(System.in).next();
		System.out.println("Enter Price::");
		BigDecimal price = new Scanner(System.in).nextBigDecimal();

		Part_Entity parts = new Part_Entity(id,name,description,price);

		com.sunbeam.dao.Parts_DAO.insertToDB(parts);
		System.out.println("Data Inserted Successfully");
	}
	
	public static void Update() {
		System.out.println("Enter Id of Part to update::");
		int id =new Scanner(System.in).nextInt();
		System.out.println("Enter price to update::");
		BigDecimal price = new Scanner(System.in).nextBigDecimal();
		
		boolean customer=com.sunbeam.dao.Parts_DAO.Update(id, price);
		 if (customer) {
		        System.out.println("Customer updated successfully");
		    } else {
		        System.out.println("Failed to update customer");
		    }
		
	}
}
