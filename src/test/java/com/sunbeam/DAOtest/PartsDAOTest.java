package com.sunbeam.DAOtest;

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

}
