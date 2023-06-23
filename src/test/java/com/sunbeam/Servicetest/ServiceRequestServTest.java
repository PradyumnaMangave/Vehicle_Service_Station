package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

class ServiceRequestServTest {

	@Test
	void testChooseCust() {
		com.sunbeam.service.Service_req_service.chooseCustomer();
	}
	
	@Test
	void testNewCustomer() {
		com.sunbeam.service.Service_req_service.createNewService(null);
	}
	
	@Test
	void testExistingCustomer() {
		com.sunbeam.service.Service_req_service.existingService(0);
	}
}
