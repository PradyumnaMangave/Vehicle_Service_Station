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

}
