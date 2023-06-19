package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
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
}


