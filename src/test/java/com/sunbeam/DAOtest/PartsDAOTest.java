package com.sunbeam.DAOtest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sunbeam.dao.Parts_DAO;
import com.sunbeam.entities.Part_Entity;

class PartsDAOTest {

	@Test
	void testShowAll() {
		List<Part_Entity> partList = new ArrayList<Part_Entity>();
		Parts_DAO parts = new Parts_DAO();
		parts.ShowAll(partList);
		for (Part_Entity part_Entity : partList) {
			System.out.println(part_Entity);
		}
	}
	
	@Test
	void testSpeciShow() {
		int id = 7;
		System.out.println(Parts_DAO.SpeciShow(id));
	}
	
	@Test
	public void testInsertToDB() {
	    Part_Entity parts = new Part_Entity(0, null, null, 0);
	    parts.setId(26);
	    parts.setName("Part 2");
	    parts.setDescription("Description 2");
	    parts.setPrice(10.0);
	    boolean result = Parts_DAO.insertToDB(parts);
	    System.out.println("Data inserted");
	}
	
}
