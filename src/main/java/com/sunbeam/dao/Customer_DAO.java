package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
