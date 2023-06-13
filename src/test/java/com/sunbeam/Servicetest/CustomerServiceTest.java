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
		Customer_Service.Delete();
	}
	
	@Test
	void testUpdate() {
		Customer_Service.update();
	}
	
	@Test
	void testShowAll() {
		Customer_Service.ShowAll();
	}

}