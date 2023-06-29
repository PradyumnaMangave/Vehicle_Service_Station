package com.sunbeam.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.ServiceReqDAO;
import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.dao.serviceDAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
import com.sunbeam.entities.Service;
import com.sunbeam.entities.ServiceRequestEntity;
	
public class Service_req_service {
	
	private static Vehicle_DAO vehicle_DAO = new Vehicle_DAO();
	private static ServiceReqDAO serviceReq =new ServiceReqDAO(); 
	private static List<ServiceRequestEntity> serviceRequests = new ArrayList<>();
	
	public static String chooseCustomer(){
		//imported show all method of customer to show all customers
		List<Customer_Entity> customerList = Customer_Service.showAll();
		
		System.out.println("Choose Customer :: ");
		//imported method to show specific customer by mobile number
		Customer_Entity customer = com.sunbeam.service.Customer_Service.speciShow1();
		
		if(customer != null) {
		//DAO method to get specific customers vehicle list
		List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity>();
		ServiceReqDAO.getVehicleByID(vehicleList, customer);
		
			if(vehicleList.size()!=0) {
				//used to get sequential ID for each vehicle info
 				for(int i=0;i<vehicleList.size();i++)
				{
					System.out.println((i+1)+" . "+vehicleList.get(i));
				}
				System.out.println("Enter ID to choose Vehicle::");
				int i = new Scanner(System.in).nextInt();
				//For choosing vehicle from vehicle list
				return vehicleList.get(i-1).getVehicle_number();
			}
		}
		else {
			System.out.println("Customer Not Found...Check mobile number again...");
			System.out.println("Enter New Customer...");
			com.sunbeam.service.Customer_Service.insertToDB();
		}
		return null;
	}

	public static ServiceRequestEntity createNewService(String vehicleNumber) {
			
			return serviceReq.addIntoServices(vehicleNumber);
				
	}

	public static ServiceRequestEntity existingService(int selectedId) {
		System.out.println("List of all service request");
		 List<ServiceRequestEntity> serviceList = serviceReq.getAllServiceRequests();
		 
		  for (ServiceRequestEntity serviceRequest : serviceList) {
		        System.out.println(serviceRequest);
		    }
		  
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter Date to show Specific Days Dervice Requests::");
	        System.out.print("Enter a date (yyyy-MM-dd): ");
	        String inputDate = scanner.nextLine();
		    List<ServiceRequestEntity> serviceList1 = serviceReq.getSpecificDayServiceRequests(inputDate);
		 
		  for (ServiceRequestEntity serviceRequest : serviceList1) {
		        System.out.println(serviceRequest);
		    }
		  
		 
		  Scanner sc = new Scanner(System.in);
		  System.out.print("Enter the ID of the existing service request: ");
		  selectedId = sc.nextInt();
		  ServiceRequestEntity selectedServiceRequest = null;
		  for (ServiceRequestEntity serviceRequest : serviceList1) {
			  if (serviceRequest.getId() == selectedId) {
				 selectedServiceRequest = serviceRequest;
				 return selectedServiceRequest;
				 }
			  }
		return null;
		}

	public static void addBill(double bill, int  service_request_id) {
	   try {
		serviceReq.updateBillAmount(bill, service_request_id);
		   
		   
		   
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

	public static ServiceRequestEntity getServiceRequestById(int serviceRequestId) {
	    for (ServiceRequestEntity serviceRequest : serviceRequests) {
	        if (serviceRequest.getId() == serviceRequestId) {
	            return serviceRequest;
	        }
	    }
	    return null;
	}

	
	
	}

	
	

	

	


