package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.ServiceReqDAO;
import com.sunbeam.dao.Vehicle_DAO;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
	
public class Service_req_service {
	
	private static Vehicle_DAO vehicle_DAO = new Vehicle_DAO();
    static List<NewVehicleEntity> vehicleList = new ArrayList<NewVehicleEntity>();
	
	public static void chooseCustomer(){
		//imported show all method of customer to show all customers
		List<Customer_Entity> customerList = Customer_Service.showAll();
		
		System.out.println("Choose Customer :: ");
		//imported method to show specific customer by mobile number
		Customer_Entity customer = com.sunbeam.service.Customer_Service.speciShow1();
		
		if(customer != null) {
		//DAO method to get specific customers vehicle list
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
				System.out.println(vehicleList.get(i-1).getVehicle_number());
			}
		}
		else {
			System.out.println("Customer Not Found...Check mobile number again...");
			System.out.println("Enter New Customer...");
			com.sunbeam.service.Customer_Service.insertToDB();
		}
	}

}
