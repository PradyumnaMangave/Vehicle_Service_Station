package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Customer_Entity;
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

	public List<Vehicle_Entity> getData() {
		
		List<Vehicle_Entity> vehicles = new ArrayList<Vehicle_Entity>();
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT * from vehicle";
			PreparedStatement pst = con.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Vehicle_Entity vehicle = new Vehicle_Entity(rs.getInt(1), rs.getString(2), rs.getString(3));
				vehicles.add(vehicle);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vehicles ;
	}

	

}
