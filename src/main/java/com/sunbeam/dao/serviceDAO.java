package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.entities.Service;
import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.entities.maintainance;
import com.sunbeam.entities.oil;
import com.sunbeam.util.DatabaseConnectivity;

public class serviceDAO {

	public static List<Service> getAllServices(ServiceRequestEntity serviceReq) {
	
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "select id,type,oil_cost,labour_charges,total_cost,remark from services where service_request_id=?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, serviceReq.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(2).equals("maintainance")) {
					maintainance maintain = new maintainance();
					maintain.setId(rs.getInt(1));
					maintain.setType(rs.getString(2));
					maintain.setLabourCharges(rs.getDouble(4));
					maintain.setTotal_cost(rs.getDouble(5));
					maintain.setRemark(rs.getString(6));
					serviceReq.getServiceList().add(maintain);
					}
				else if(rs.getString(2).equals("oil")){
					oil oil = new oil(0);
					oil.setId(rs.getInt(1));
					oil.setOil_cost(rs.getDouble(3));
					oil.setTotal_cost(rs.getDouble(5));
					oil.setRemark(rs.getString(6));
					serviceReq.getServiceList().add(oil);
				}
				else {
					System.out.println("Enter correct type...");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceReq.getServiceList();
	}

	public static void createNewMaintainance(ServiceRequestEntity serviceRequest, Service service) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "INSERT INTO services (service_request_id,remark,type,oil_cost, labour_charges, total_cost ) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			if(service instanceof maintainance)
			{ 
			pst.setInt(1, serviceRequest.getId());
	        pst.setString(2, service.getRemark());
	        pst.setString(3,"maintainance");
	        pst.setDouble(4, 0);
	        pst.setDouble(5, ((maintainance)service).getLabourCharges());
	        pst.setDouble(6, service.getTotal_cost());
	        
	        int rs = pst.executeUpdate();
			}
			
				}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
