package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	
	
	static Connection con;
	public static Connection create()
	{
	 
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3306/employee_management_system";
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

