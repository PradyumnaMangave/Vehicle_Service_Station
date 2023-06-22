package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.serviceDAO;
import com.sunbeam.entities.Service;
import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.entities.maintainance;
import com.sunbeam.entities.oil;

public class Service_service {

	public static void getAllService(ServiceRequestEntity serviceRequest) {
		
		List<Service> serviceList = com.sunbeam.dao.serviceDAO.getAllServices(serviceRequest);
		//System.out.println(serviceList);
		System.out.println(serviceRequest.getServiceList());
	}

	public static void doMaintainance(ServiceRequestEntity serviceRequest) {
		List<Service> serviceList = serviceRequest.getServiceList();
		maintainance service = null;
		boolean serviceFound = false;
		if(serviceList.isEmpty()) {
			service = new maintainance();
			serviceList.add(service);
			service.acceptService();
			service.calculateTotalCost();
			serviceDAO.createNewMaintainance(serviceRequest, service);
		}
		else {
			for(Service S : serviceList) {
				if(S instanceof maintainance) {
						service = (maintainance) S;
				serviceFound = true;
			}
		}
			if(!serviceFound) {
				service = new maintainance();
				serviceList.add(service);
				service.acceptService();
				service.calculateTotalCost();
				serviceDAO.createNewMaintainance(serviceRequest, service);
			}
		
	}
		
	}

	public static void doOilChange(ServiceRequestEntity serviceRequest) {
		List<Service> serviceList = serviceRequest.getServiceList();
		oil service = null;
		boolean serviceFound = false;
		if(serviceList.isEmpty()) {
			service = new oil();
			serviceList.add(service);
			service.acceptService();
			service.calculateTotalCost();
			serviceDAO.createNewOilChange(serviceRequest, service);
		}
		else {
			for(Service S : serviceList) {
				if(S instanceof oil) {
						service = (oil) S;
				serviceFound = true;
			}
		}
			if(!serviceFound) {
				service = new oil();
				serviceList.add(service);
				service.acceptService();
				service.calculateTotalCost();
				serviceDAO.createNewOilChange(serviceRequest, service);
			}
		
	}
		
	} 
	
	

    
	}
