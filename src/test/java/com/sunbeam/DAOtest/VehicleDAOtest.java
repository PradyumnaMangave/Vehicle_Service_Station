package com.sunbeam.DAOtest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
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

	@Test
	void testSpeciShow() {
		List<NewVehicleEntity> list = new ArrayList<NewVehicleEntity>();
		Vehicle_DAO vehi = new Vehicle_DAO();
		Customer_Entity cust = new Customer_Entity(0, null, null, null, null);
		cust.setId(14);
		vehi.speciCustomer(list, cust);
		System.out.println(list);
	}
	
	@Test
    public void testShowAll() {
        List<NewVehicleEntity> vehicleList = new ArrayList<>();
        Customer_Entity cust = new Customer_Entity(0, null, null, null, null);
        Vehicle_DAO vehi = new Vehicle_DAO();
        vehi.ShowAll(vehicleList, cust);
        System.out.println(vehicleList);
    }
	
	@Test
	public void testUpdate() {
	    String old_vehicle_number="MH09AU4678";
	    String new_vehicle_number="MH23FM9306";
	    Vehicle_DAO.update_Number(old_vehicle_number, new_vehicle_number);
	    System.out.println("vehicle number updated...");
	}
	
	@Test
	public void testSearchNumber() {
		 String existingNumber = "MH23FM96";
		 Vehicle_DAO vehi = new Vehicle_DAO();
	     boolean result1 = vehi.searchNumber(existingNumber);
	     System.out.println("Vehicle number found: " + result1);
	}
	
	@Test
	public void testSpeciCustomerByVehiNum() {
		 String existingVehicleNumber = "MH23FM9306";
	        List<NewVehicleEntity> vehicleList = new ArrayList<>();
	        Customer_Entity cust = new Customer_Entity(0, existingVehicleNumber, existingVehicleNumber, existingVehicleNumber, existingVehicleNumber);
	        Vehicle_DAO vehi = new Vehicle_DAO();
	        vehi.speciCustomerByVehiNum(vehicleList, cust, existingVehicleNumber);
	        System.out.println("Vehicle List:");
	        for (NewVehicleEntity vehicle : vehicleList) {
	            System.out.println(vehicle);
	        }
	}
	
	@Test
	public void testDelete() {
		String existingVehicleNumber = "MH12JH4321";
		Vehicle_DAO vehi = new Vehicle_DAO();
        boolean result1 = vehi.Delete(existingVehicleNumber);
        System.out.println("Vehicle deleted: " + result1);
	}
}


