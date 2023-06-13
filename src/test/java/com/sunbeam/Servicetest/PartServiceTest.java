package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

import com.sunbeam.service.Part_Service;

class PartServiceTest {

	@Test
	void testShowAll() {
		Part_Service.ShowAll();
	}
	
	@Test
	void testSpeciShow() {
		Part_Service.SpeciShow();
	}
	
	@Test
	void testInsertToDb() {
		Part_Service.insertToDB();
	}
	
	@Test
	void testUpdate() {
		Part_Service.Update();
	}
	
	@Test
	void testDelete() {
		Part_Service.delete();
	}
}
