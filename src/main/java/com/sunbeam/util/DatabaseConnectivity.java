package com.sunbeam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
	
	
	static Connection con;
	public static Connection create()
	{
	 
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		String URL = "jdbc:mysql://localhost:3306/Vehicle_Service_Station_DB";
		String Username = "root";
		String Password = "SqlPr@9306";
		
		con=DriverManager.getConnection(URL,Username,Password);
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;

}
}

