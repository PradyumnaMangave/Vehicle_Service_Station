package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunbeam.util.DatabaseConnectivity;

public class BusinessDAO {

	public static double calculateBusinessForDate(String inputDate) {
	    double totalBusiness = 0.0;

	    try {
	        Connection con = DatabaseConnectivity.create();
	        String sql = "SELECT SUM(paid_amount) AS total FROM payments WHERE tx_date = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, inputDate);

	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            totalBusiness = rs.getDouble("total");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalBusiness;
	}


    public static double calculateTotalBusiness() {
        double totalBusiness = 0.0;

        try {
            Connection con = DatabaseConnectivity.create();
            String sql = "SELECT SUM(paid_amount) AS total FROM payments WHERE DATE(tx_date) = CURDATE()";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalBusiness = rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalBusiness;
    }

}
