package com.sunbeam.service;

import java.util.Scanner;

import com.sunbeam.entities.ServiceRequestEntity;

public class paymentService {

	 public static void getPayment(int serviceRequestId) {
	        ServiceRequestEntity service = Service_req_service.existingService(serviceRequestId);

	        if (service != null) {
	            double paymentAmount = service.getBillAmount();
	            double finalPayment = paymentAmount + (paymentAmount * 0.126);

	            System.out.println("Total Amount to be Paid after adding 12.6% GST : " + finalPayment);

	            Scanner scanner = new Scanner(System.in);
	            
	            int service_Request_Id = service.getId();
	            System.out.print("Enter the payment amount: ");
	            double payment = scanner.nextDouble();

	            // Add the payment to the database
	           com.sunbeam.dao.paymentDAO.addPaymentToDB(payment, service_Request_Id);
	        } else {
	            System.out.println("Invalid service request ID. Please choose the correct ID.");
	        }
	    }
}

