package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.serviceDAO;
import com.sunbeam.entities.Part_Entity;
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
				break;
			}
		}
			if(serviceFound) {
				service.acceptService();
	            service.calculateTotalCost();
	            serviceDAO.updateMaintainance(serviceRequest, service);
			}
			else {
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
				break;
			}
		}
			if(serviceFound){
				service.acceptService();
	            service.calculateTotalCost();
	            serviceDAO.updateOilChange(serviceRequest, service);
			}
			else {
				service = new oil();
				serviceList.add(service);
				service.acceptService();
				service.calculateTotalCost();
				serviceDAO.createNewOilChange(serviceRequest, service);
			}
		
	}
		
	}

	public static void doRepairing(ServiceRequestEntity serviceRequest) {
		List<Service> serviceList = serviceRequest.getServiceList();
		maintainance service = null;
		boolean serviceFound = false;
		if(serviceList.isEmpty()) {
			service = new maintainance();
		}
		else {
			for(Service S : serviceList) {
				if(S instanceof maintainance) {
						service = (maintainance) S;
				serviceFound = true;
				break;
			}
		}
			if(serviceFound) {
				System.out.println("List of all parts:");
				Part_Service.showAll();
				int specID = Part_Service.SpeciShow();
				
				int SID=serviceRequest.getId();
				int PID = specID;
				System.out.println("Enter Quantities of parts");
				int QID = new Scanner(System.in).nextInt();
				service.acceptPart();
				Part_Entity parts = new Part_Entity(QID, null, null, QID);

				Service_service.calculateTotalCostWParts(QID , service, parts);

				serviceDAO.insertMainRepair(SID, PID, QID);
				
	            serviceDAO.updateMaintainance(serviceRequest, service);
			}
			else {
				service = new maintainance();
				serviceList.add(service);
				service.acceptService();
				service.calculateTotalCost();
				serviceDAO.createNewMaintainance(serviceRequest, service);
			}
		
	}
		
	}

	private static void calculateTotalCostWParts(int QID, maintainance service, Part_Entity parts) {
		double totalCost = service.getLabourCharges() + parts.getPrice() * QID + service.getTotal_cost();
		service.setTotal_cost(totalCost);
		
	}
    
	}
