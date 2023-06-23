package com.sunbeam.DAOtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sunbeam.dao.ServiceReqDAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.ServiceRequestEntity;

class ServiceReqDAOTest<NewVehicleEntity> {

	 private ServiceRequestEntity result;

	@Test
	    public void testGetVehicleByID() {
	        List<NewVehicleEntity> vehicleList = new ArrayList<>();
	        Customer_Entity cust = new Customer_Entity(0, null, null, null, null);
	        cust.setId(1);
	        ServiceReqDAO.getVehicleByID(null, cust);
	        assertEquals(0, vehicleList.size());
	        System.out.println("Tested");
	        
	    }
	 
	 @Test
	 public void testAddIntoServices() {
		 ServiceReqDAO serviceRequestDao = new ServiceReqDAO();
	      String vehicleNumber = "mh09da9306";
	       result = serviceRequestDao.addIntoServices(vehicleNumber);
	 }
	 
	 @Test
	 public void testGetAllServiceRequests() {
		 ServiceReqDAO serviceRequestDao = new ServiceReqDAO();
	        
	       
	        List<ServiceRequestEntity> serviceRequests = serviceRequestDao.getAllServiceRequests();
	        
	        // Perform assertions to verify the results
	        Assertions.assertNotNull(serviceRequests);
	        Assertions.assertFalse(serviceRequests.isEmpty());
	        System.out.println("Tetsted");
	 }
	 
	 @Test
	 public void testGetSpecificDayServiceRequests() {
		 ServiceReqDAO serviceRequestDao = new ServiceReqDAO();
	        List<ServiceRequestEntity> serviceRequests = serviceRequestDao.getSpecificDayServiceRequests(null);
	        System.out.println("Tetsted");
	 }
}
