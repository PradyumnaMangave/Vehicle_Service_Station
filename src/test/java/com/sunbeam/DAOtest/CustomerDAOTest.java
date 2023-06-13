package com.sunbeam.DAOtest;

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

}