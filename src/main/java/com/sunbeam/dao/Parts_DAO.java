package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.entities.Part_Entity;
import com.sunbeam.util.DatabaseConnectivity;

public class Parts_DAO {

	public static boolean ShowAll(List<Part_Entity> partList) {
		boolean f = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "SELECT * from parts";
			PreparedStatement pst = con.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Part_Entity part_Entity = new Part_Entity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				partList.add(part_Entity);
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
			String SQL = "SELECT * from Parts WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				Part_Entity part_Entity = new Part_Entity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				System.out.println(part_Entity);
			}
			else {
				System.out.println("ID not found... Check it again...");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean insertToDB(Part_Entity parts) {
		boolean f = false;
		try {
			Connection con = DatabaseConnectivity.create();
			String SQL = "INSERT into parts (id,name,description,price) values (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, parts.getId());
			pst.setString(2, parts.getName());
			pst.setString(3, parts.getDescription());
			pst.setBigDecimal(4, parts.getPrice());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
