package com.sunbeam.Servicetest;

import org.junit.jupiter.api.Test;

import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.service.Part_Service;
import com.sunbeam.service.Service_service;

class serviceTest {

	@Test
	public void testGetAllService(){
		ServiceRequestEntity serviceRequestEntity = new ServiceRequestEntity();
		Service_service.getAllService(serviceRequestEntity);
		System.out.println("tested");
	}
	
	@Test
	public void testDoMaintainance() {
		ServiceRequestEntity serviceRequestEntity = new ServiceRequestEntity();
		Service_service.doMaintainance(serviceRequestEntity);
		System.out.println("tested");
	}
	
	@Test
	public void testdDoOilChange() {
		ServiceRequestEntity serviceRequestEntity = new ServiceRequestEntity();
		Service_service.doOilChange(serviceRequestEntity);
		System.out.println("tested");
	}
	
	@Test
	public void testDoRepairing() {
		ServiceRequestEntity serviceRequestEntity = new ServiceRequestEntity();
		Service_service.doRepairing(serviceRequestEntity);
		
		System.out.println("running");
	}

}
