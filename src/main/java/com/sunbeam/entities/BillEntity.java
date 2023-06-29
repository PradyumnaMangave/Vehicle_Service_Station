package com.sunbeam.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sunbeam.dao.Parts_DAO;
import com.sunbeam.dao.ServiceReqDAO;
import com.sunbeam.service.Customer_Service;
import com.sunbeam.service.Part_Service;
import com.sunbeam.service.Service_req_service;
import com.sunbeam.service.Service_service;
import com.sunbeam.service.Vehicle_service;

public class BillEntity {
private String Service_Station_Name = "Universal Garage";
private Customer_Entity Customer;
private  Customer_Vehicle_Entity Cust_Vehicle;
private ServiceRequestEntity ServiceRequest;
private Part_Entity Part;
private Map<Part_Entity, Integer> partList;
private NewVehicleEntity newVehi;

public void prepareBill(int serviceRequestId) {
    this.ServiceRequest = Service_req_service.existingService(serviceRequestId);

    if (this.ServiceRequest != null) {
        Service_service.getAllService(ServiceRequest);
        List<Service> serviceList = ServiceRequest.getServiceList();
        
        double bill = 0;
        for (Service service : serviceList) {
            bill = bill + service.getTotal_cost();
        }

        this.ServiceRequest.setBillAmount(bill);
        Service_req_service.addBill(bill, ServiceRequest.getId());
        fetchAllData();
    } else {
        System.out.println("Service Request not found.");
    }
}


private void fetchAllData() {
    this.newVehi = Vehicle_service.speciCustomerV(this.ServiceRequest.getVehicleNumber());
    this.Customer = Customer_Service.getSpeciCustomer(this.ServiceRequest.getVehicleNumber());
    List<Service> serviceList = this.ServiceRequest.getServiceList();
    maintainance maintain = null;

    for (Service service : serviceList) {
        if (service instanceof maintainance)
            maintain = (maintainance) service;
    }

    if (maintain != null) {
        Service_service.getServicePartsList(maintain);
        this.partList = Part_Service.getAllServiceParts(maintain.getPartsList());
    }

    displayBill();
}



private void displayBill() {
    System.out.println("--------------------------------------------------");
    System.out.println("                SERVICE BILL");
    System.out.println("--------------------------------------------------");
    System.out.println("Service Station Name: " + Service_Station_Name);
    System.out.println("Service Date: " + this.ServiceRequest.getReqDate()); // You can modify this to use the actual service date
    System.out.println("Customer Name: " + this.Customer.getName() + " Mobile Numer: " + this.Customer.getMobile() + " Email Address: " + this.Customer.getEmail()+ "  Address: " + this.Customer.getAddress());
    System.out.println("Customer Vehicle Details: Company: " + this.newVehi.getVehicle_number() + "  Model: " + this.newVehi.getCompany() +  " Vehicle Number: "  +this.newVehi.getModel());
    System.out.println("--------------------------------------------------");
    System.out.println("                SERVICES PROVIDED");
    System.out.println("--------------------------------------------------");

    List<Service> serviceList = ServiceRequest.getServiceList();
    for (Service service : serviceList) {
        System.out.println(service.getRemark());
    }

    System.out.println("--------------------------------------------------");
    System.out.println("                SPARE PARTS COST");
    System.out.println("--------------------------------------------------");

    double totalPartsCost = 0.0; // Variable to keep track of the total spare parts cost

    for (Map.Entry<Part_Entity, Integer> entry : partList.entrySet()) {
        Part_Entity part = entry.getKey();
        int quantity = entry.getValue();
        double partCost = part.getPrice() * quantity;
        totalPartsCost += partCost; // Accumulate the part cost
        System.out.println(part.getName() + " (Quantity: " + quantity + "): " + partCost);
        System.out.println("Total Spare Parts Cost: " + totalPartsCost);
    }

    System.out.println("--------------------------------------------------");
    maintainance maintenance = null;
    oil oil = null;
    for (Service service : serviceList) {
        if (service instanceof maintainance) {
            maintenance = (maintainance) service;
        } else if (service instanceof oil) {
            oil = (oil) service;
        }
    }

    if (maintenance != null) {
        System.out.println("Maintenance Charges (Labor Charges): " + maintenance.getLabourCharges());
    }
    if (oil != null) {
        System.out.println("Oil/Additive Price: " + oil.getOil_cost());
    }
    double billAmount = ServiceRequest.getBillAmount();
    double finalBill = billAmount + (billAmount * 0.126); // Applying 12.6% tax
    System.out.println("--------------------------------------------------");
    System.out.println("Bill Amount: " + billAmount);
    System.out.println("Final Bill (including 12.6% tax): " + finalBill);
    System.out.println("--------------------------------------------------");
}

}
