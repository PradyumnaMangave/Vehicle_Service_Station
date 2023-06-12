package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunbeam.entities.Vehicle_Entity;
import com.sunbeam.util.DatabaseConnectivity;

public class Vehicle_DAO {

	public static void insertToDB(Vehicle_Entity vehicle_Entity) {
		boolean f = false;
		
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "INSERT into vehicle (id,company,model) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, vehicle_Entity.getId());
			pst.setString(2, vehicle_Entity.getCompany());
			pst.setString(3, vehicle_Entity.getModel());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
