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
		Vehicle_service.SpeciCustomer();
	}
	
	@Test
	void testUpdateVehicle() {
		Vehicle_service.Update();
	}
	
	@Test
	void testShowAll() {
		Vehicle_service.ShowAll();
	}
	
	@Test
	void testDelete() {
		Vehicle_service.Delete();
	}
	
}
