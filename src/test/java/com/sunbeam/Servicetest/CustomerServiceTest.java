package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

import com.sunbeam.service.Customer_Service;

class CustomerServiceTest {

	@Test
	void testinsertTodb() {
		Customer_Service.insertToDB();
	}
	
	@Test
	void testDelete() {
		Customer_Service.delete();
	}
	
	@Test
	void testUpdate() {
		Customer_Service.update();
	}
	
	@Test
	void testShowAll() {
		Customer_Service.showAll();
	}
	
	@Test
	void testSpeciShow() {
		Customer_Service.speciShow();
	}

}