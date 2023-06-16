package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.entities.NewVehicleEntity;
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

	public void EnterIntoVehicle(String vehicle_number,int customer_id,int vehicle_id) {
			try {
				Connection con = DatabaseConnectivity.create();
				String SQL = "INSERT into customer_vehicle (vehicle_number,customer_id,vehicle_id) values (?,?,?)";
				PreparedStatement pst = con.prepareStatement(SQL);
				pst.setString(1, vehicle_number);
				pst.setInt(2, customer_id);
				pst.setInt(3, vehicle_id);
				pst.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void speciCustomer(List<NewVehicleEntity> vehicleList,Customer_Entity cust) {
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
	
	public void ShowAll(List<NewVehicleEntity> vehicleList,Customer_Entity cust) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT c.name,v.company, v.model, cv.vehicle_number FROM vehicle v INNER JOIN customer_vehicle cv ON v.id = cv.vehicle_id INNER JOIN customer c ON c.id=cv.customer_id";
			PreparedStatement pst = con.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NewVehicleEntity vehicle = new NewVehicleEntity(rs.getString(1),rs.getString(4), rs.getString(2), rs.getString(3));
				vehicleList.add(vehicle);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update_Number(String old_Vehicle_Number, String new_Vehicle_Number) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "UPDATE customer_vehicle SET vehicle_number=? Where vehicle_number=?;";
			PreparedStatement pst = con.prepareStatement(SQL);
			
			pst.setString(2, old_Vehicle_Number);
			pst.setString(1, new_Vehicle_Number);
			pst.execute();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean searchNumber(String old_Vehicle_Number) {
		boolean vehicleFound = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "Select * from customer_vehicle Where vehicle_number=?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, old_Vehicle_Number);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				vehicleFound = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleFound;
	}

	public void speciCustomerByVehiNum(List<NewVehicleEntity> vehicleList, Customer_Entity customer,String vehicle_number) {
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT c.name ,v.company, v.model, cv.vehicle_number FROM vehicle v INNER JOIN customer_vehicle cv ON v.id = cv.vehicle_id INNER JOIN customer c ON c.id=cv.customer_id WHERE cv.vehicle_number = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, vehicle_number);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NewVehicleEntity vehicle = new NewVehicleEntity(rs.getString(1),rs.getString(4), rs.getString(2), rs.getString(3));
				vehicleList.add(vehicle);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean Delete(String vehicle_number) {
		boolean vehicleDeleted = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "DELETE from customer_vehicle WHERE vehicle_number = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, vehicle_number);
			int rs =pst.executeUpdate();
			if(rs==1) {
				vehicleDeleted = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleDeleted;
		
	}
}
