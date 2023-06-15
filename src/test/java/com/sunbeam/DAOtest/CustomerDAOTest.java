package com.sunbeam.DAOtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.sunbeam.dao.Customer_DAO;
import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Entity;

class CustomerDAOTest {

	@Test
	void testinsertTodb() throws SQLException {

			Customer_Entity cust = new Customer_Entity(9, "test", "9988777788", "test", "test");
			System.out.println(Customer_DAO.insertToDB(cust));

	}
	
	@Test
	void testDeleteFromDB() throws SQLException {
	    Customer_Entity cust = new Customer_Entity(17, "test", "9988777788", "test", "test");
	    Customer_DAO.insertToDB(cust);
	    boolean deletionSuccessful = Customer_DAO.Delete(cust.getId());
	    assertTrue(deletionSuccessful);
	}
	
	@Test
	void testUpdateExistingCustomer() throws SQLException {

	    
	    int id = 18;
	    String mobile = "9988777788";
	    String address = "test";
	    Customer_DAO.insertToDB(new Customer_Entity(id, "test", mobile, address, "test"));

	    String newMobile = "9876543210";
	    String newAddress = "updatedAddress";
	    boolean updateSuccessful = Customer_DAO.update(id, newMobile, newAddress);
	    
	    assertTrue(updateSuccessful);
	}

	@Test
	void testUpdateNonExistingCustomer() throws SQLException {

	    
	    int id = 99;
	    String mobile = "9876543210";
	    String address = "updatedAddress";
	    boolean updateSuccessful = Customer_DAO.update(id, mobile, address);

	    assertFalse(updateSuccessful);
	}

	@Test 
	void testSpecificCustomer() {
		int id = 14;
		Customer_DAO.SpeciShow(null);
		System.out.println("Tested");
	}
	
	@Test
	void testShowAll() {
		Customer_DAO.ShowAll(null);
		System.out.println("tested");
	}
}