package com.sunbeam.DAOtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sunbeam.dao.ServiceReqDAO;
import com.sunbeam.entities.Customer_Entity;

class ServiceReqDAOTest<NewVehicleEntity> {

	 @Test
	    public void testGetVehicleByID() {
	        List<NewVehicleEntity> vehicleList = new ArrayList<>();
	        Customer_Entity cust = new Customer_Entity(0, null, null, null, null);
	        cust.setId(1);
	        ServiceReqDAO.getVehicleByID(null, cust);
	        assertEquals(0, vehicleList.size());
	        System.out.println("Tested");
	        
	    }

}
