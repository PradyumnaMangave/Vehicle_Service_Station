package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

import com.sunbeam.service.Customer_Service;

class CustomerServiceTest {

	@Test
	void testinsertTodb() {
		Customer_Service.insertToDB();
	}

}
