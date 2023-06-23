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
					oil oil = new oil();
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

	public static void createNewOilChange(ServiceRequestEntity serviceRequest, oil service) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "INSERT INTO services (service_request_id,remark,type,oil_cost, labour_charges, total_cost ) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			if(service instanceof oil)
			{ 
			pst.setInt(1, serviceRequest.getId());
	        pst.setString(2, service.getRemark());
	        pst.setString(3,"oil");
	        pst.setDouble(4, service.getOil_cost());
	        pst.setDouble(5, 0);
	        pst.setDouble(6, service.getTotal_cost());
	        
	        int rs = pst.executeUpdate();
			}
			
				}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateMaintainance(ServiceRequestEntity serviceRequest, Service service) {
	    try {
	        Connection con = DatabaseConnectivity.create();
	        String SQL = "UPDATE services SET remark = CONCAT(?, ' , ', remark), labour_charges = labour_charges + ?, total_cost = total_cost + ? WHERE id = ?";
	        PreparedStatement pst = con.prepareStatement(SQL);
	        pst.setString(1, service.getRemark());
	        pst.setDouble(2, ((maintainance) service).getLabourCharges());
	        pst.setDouble(3, service.getTotal_cost());
	        pst.setInt(4, service.getId());
	        int rowsUpdated = pst.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Maintenance service updated successfully.");
	        } else {
	            System.out.println("Failed to update maintenance service.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void updateOilChange(ServiceRequestEntity serviceRequest, oil service) {
		try {
	        Connection con = DatabaseConnectivity.create();
	        String SQL = "UPDATE services SET remark = CONCAT(?, ' , ', remark), oil_cost = oil_cost + ?, total_cost = total_cost + ? WHERE id = ?";
	        PreparedStatement pst = con.prepareStatement(SQL);
	        pst.setString(1, service.getRemark());
	        pst.setDouble(2, service.getOil_cost());
	        pst.setDouble(3, service.getTotal_cost());
	        pst.setInt(4, service.getId());
	        int rowsUpdated = pst.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Maintenance service updated successfully.");
	        } else {
	            System.out.println("Failed to update maintenance service.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

		
	}



