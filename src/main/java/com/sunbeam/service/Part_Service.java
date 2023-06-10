package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.Customer_DAO;
import com.sunbeam.dao.Parts_DAO;
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
}
