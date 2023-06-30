package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import DBUtil.database;
import Entities.DeptEntities;
import Entities.EmpEntities;

public class EmpDAO {

	public static void insertIntoEmployeeTable(int id, String name, String job, int manager, Date hireDate,
			double salary, int deptNo) {
		
		try {
			Connection con = database.create();
			String SQL = "insert into emp (empno,ename,job,mgr,hiredate,sal,deptno) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, job);
			pst.setInt(4, manager);
			pst.setDate(5, (java.sql.Date) hireDate);
			pst.setDouble(6, salary);
			pst.setInt(7, deptNo);
			
			pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void update() {
		try {
			Connection con = database.create();
			String SQL = "UPDATE emp SET sal = sal * 1.1 WHERE deptno = 20;";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void listEmp(String year) {
		try {
			Connection con = database.create();
			String SQL = "SELECT e.empno, e.ename, d.dname FROM emp e JOIN dept d ON e.deptno = d.deptno  WHERE YEAR(e.hiredate) = ?";
			PreparedStatement pst = con.prepareStatement(SQL);
			  pst.setString(1, year);
	           ResultSet resultSet = pst.executeQuery();

	            while (resultSet.next()) {
	                int empno = resultSet.getInt("empno");
	                String ename = resultSet.getString("ename");
	                String dname = resultSet.getString("dname");

	                DeptEntities department = new DeptEntities(empno, dname, dname);
	                department.setDname(dname);

	                EmpEntities employee = new EmpEntities(empno, dname, dname, empno, null, empno, empno);
	                employee.setEmpno(empno);
	                employee.setEname(ename);
	                employee.setDepartment(department);

	                EmpEntities.add(employee);
	            }
	            
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
