package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunbeam.util.DatabaseConnectivity;

public class paymentDAO {

	public static void addPaymentToDB(double finalPayment,int  service_Request_Id) {
		
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "INSERT INTO payments (service_request_id,paid_amount) VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setDouble(2, finalPayment);
			pst.setInt(1, service_Request_Id);
			int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Amount Paid...");
            } else {
                System.out.println("Failed to add payment to the table.");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
