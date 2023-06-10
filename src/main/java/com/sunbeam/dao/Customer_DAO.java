package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.entities.Customer_Entity;
import com.sunbeam.util.DatabaseConnectivity;

public class Customer_DAO {

	public static boolean insertToDB(Customer_Entity customer) {
		
		boolean f = false;
		try {
		Connection con = DatabaseConnectivity.create();
		String SQL = ("INSERT into customer (id,name,mobile,email,address) values (? ,? ,? ,? ,?)");
		PreparedStatement pst = con.prepareStatement(SQL);
		
		pst.setInt(1, customer.getId());
		pst.setString(2, customer.getName());
		pst.setString(3, customer.getMobile());
		pst.setString(4, customer.getEmail());
		pst.setString(5, customer.getAddress());
		
		pst.executeUpdate();
	}catch (Exception E)
	{
		E.printStackTrace();
	}
	return f;
	}

	public static boolean Delete(int id) {
		
		boolean f = false;
		try {
		Connection con=DatabaseConnectivity.create();
		String SQL = "DELETE from customer WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(SQL);
		
		pst.setInt(1, id);
		int count = pst.executeUpdate();
		if(count != 0)
		f=true;
		}catch (Exception e) {
			e.printStackTrace();
	}
	return f;	
}


	public static boolean ShowAll(List<Customer_Entity> customerList) {
		boolean f = false;
		try {
		Connection con = DatabaseConnectivity.create();
		String SQL = "SELECT * FROM customer";
		PreparedStatement pst = con.prepareStatement(SQL);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
		Customer_Entity customer = new Customer_Entity ( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				customerList.add(customer);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean SpeciShow(int id) {
		boolean f = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT * FROM customer WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, id);
				
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Customer_Entity customer = new Customer_Entity ( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				System.out.println(customer);
				}
			else {
				System.out.println("Customer Not Found....Check ID again..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	    
	   
	}

	public static boolean update(int id,String mobile,String address) {
		boolean f = false;
	try {
		Connection con = DatabaseConnectivity.create();
		String SQL = "UPDATE customer SET mobile = ? , address = ? WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(SQL);
		pst.setString(1, mobile);
		pst.setString(2, address);
		pst.setInt(3, id);
		 int rowsAffected = pst.executeUpdate();
		 if (rowsAffected > 0) 
		 {
			 f = true;
	        }	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	}

	public static boolean updateMobile(int id, String mobile) {
		
		boolean f = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "UPDATE customer SET mobile = ? WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, mobile);
			pst.setInt(2, id);
			 int rowsAffected = pst.executeUpdate();
			 if (rowsAffected > 0) 
			 {
				 f = true;
		        }	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		}

	public static boolean updateAddress(int id, String address) {
		
		boolean f = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "UPDATE customer SET address = ? WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, address);
			pst.setInt(2, id);
			 int rowsAffected = pst.executeUpdate();
			 if (rowsAffected > 0) 
			 {
				 f = true;
		        }	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		}
}
