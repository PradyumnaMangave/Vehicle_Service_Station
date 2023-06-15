package com.sunbeam.DAOtest;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.sunbeam.dao.Customer_DAO;
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

}