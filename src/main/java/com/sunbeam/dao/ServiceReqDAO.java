package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.Customer_Vehicle_Entity;
import com.sunbeam.entities.NewVehicleEntity;
import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.entities.Vehicle_Entity;
import com.sunbeam.util.DatabaseConnectivity;

public class ServiceReqDAO {

	public static void getVehicleByID(List<NewVehicleEntity> vehicleList,Customer_Entity cust) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT c.name ,v.company, v.model, cv.vehicle_number FROM vehicle v INNER JOIN customer_vehicle cv ON v.id = cv.vehicle_id INNER JOIN customer c ON c.id=cv.customer_id WHERE cv.customer_id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, cust.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NewVehicleEntity vehicle = new NewVehicleEntity(rs.getString(1),rs.getString(4), rs.getString(2), rs.getString(3));
				vehicleList.add(vehicle);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ServiceRequestEntity addIntoServices(String vehicleNumber) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "Insert into service_requests (vehicle_number) values (?)";
			PreparedStatement pst = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, vehicleNumber);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				return new ServiceRequestEntity(rs.getInt(1),vehicleNumber);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ServiceRequestEntity> getAllServiceRequests()  {
	    List<ServiceRequestEntity> serviceRequests = new ArrayList<>();
	    
	    try {
	        Connection con = DatabaseConnectivity.create();
	        String SQL = "SELECT * FROM service_requests";
	        PreparedStatement pst = con.prepareStatement(SQL);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String vehicleNumber = rs.getString("vehicle_number");
	            Date requestDate = rs.getDate("request_date");
	            
	            ServiceRequestEntity serviceRequest = new ServiceRequestEntity(id, vehicleNumber,requestDate, rs.getDouble("bill_amount"));
	            serviceRequests.add(serviceRequest);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return serviceRequests;
	}

	public List<ServiceRequestEntity> getSpecificDayServiceRequests(String inputDate) {
		List<ServiceRequestEntity> serviceRequests = new ArrayList<>();
	    
	    try {
	        Connection con = DatabaseConnectivity.create();
	        String SQL = "SELECT * FROM service_requests where Date(request_date)=?";
	        PreparedStatement pst = con.prepareStatement(SQL);
	        ServiceRequestEntity serv = new ServiceRequestEntity();
	        pst.setString(1, inputDate);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String vehicleNumber = rs.getString("vehicle_number");
	            Date requestDate = rs.getDate("request_date");
	            
	            ServiceRequestEntity serviceRequest = new ServiceRequestEntity(id, vehicleNumber,requestDate, rs.getDouble("bill_amount"));
	            serviceRequests.add(serviceRequest);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return serviceRequests;
	}

	public static void updateBillAmount(double bill,int service_request_id) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "Update service_requests set bill_amount = ? where id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setDouble(1, bill);
			pst.setInt(2, service_request_id);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public NewVehicleEntity speciCustomerV(String vehicleNumber) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT v.company, v.model, cv.vehicle_number FROM vehicle v INNER JOIN customer_vehicle cv ON cv.vehicle_id = v.id WHERE vehicle_number = ?";

			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, vehicleNumber);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NewVehicleEntity custVehi = new NewVehicleEntity(rs.getString(1),rs.getString(2),vehicleNumber);
				return custVehi;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

		
}




