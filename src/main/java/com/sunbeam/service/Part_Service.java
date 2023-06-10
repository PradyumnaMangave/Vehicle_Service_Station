package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;

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
}
