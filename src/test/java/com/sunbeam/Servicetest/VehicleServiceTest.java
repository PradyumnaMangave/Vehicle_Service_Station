package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

import com.sunbeam.service.Vehicle_service;

class VehicleServiceTest {

	@Test
	void testInsertToDb() {
		Vehicle_service.insertToDb();
	}
	
	@Test
	void testAddDataInVehicle() {
		Vehicle_service.vehicle_add();
	}

	@Test
	void testSpeciShow() {
		Vehicle_service.speciCustomer();
	}
	
	@Test
	void testUpdateVehicle() {
		Vehicle_service.update();
	}
	
	@Test
	void testShowAll() {
		Vehicle_service.showAll();
	}
	
	@Test
	void testDelete() {
		Vehicle_service.delete();
	}
	
}
