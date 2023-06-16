package com.sunbeam.DAOtest;

import org.junit.jupiter.api.Test;

import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Vehicle_Entity;
import com.sunbeam.entities.Vehicle_Entity;

class VehicleDAOtest {

	@Test
	void testInsertDb() {
		Vehicle_Entity vehicle =new Vehicle_Entity(0, null, null);
		Vehicle_DAO VehiDao = new Vehicle_DAO();
		vehicle.setId(23);
		vehicle.setCompany("Bajaj");
		vehicle.setModel("Dominor");
		VehiDao.insertToDB(vehicle);
		System.out.println("Done");
	}
	
	@Test
	void testEnterIntoVehicle() {
		Vehicle_DAO vehi = new Vehicle_DAO();
		vehi.EnterIntoVehicle("MH09FG5432", 8, 7);
		System.out.println("Done");
		}

	}

	


