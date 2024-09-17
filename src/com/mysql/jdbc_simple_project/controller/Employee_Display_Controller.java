package com.mysql.jdbc_simple_project.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_Display_Controller {
	public static void main(String[] args) {
		Connection conn=null;
	
	
	try {
		//  load/register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// step-2  Create Connection
		
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user="root";
		String pass="root";
		
		 conn=DriverManager.getConnection(url,user,pass);
		
		
		//step-3 Create Statement
		
		Statement st=conn.createStatement();
		
		// step-4 Execute Query
		String display="Select * from employee";
		
		ResultSet rs=st.executeQuery(display);
		
		while(rs.next())
		{
			int EmpID=rs.getInt("id");
			String Empname=rs.getString("name");
			String Empemail=rs.getNString("email");
			long Empphone=rs.getLong("phone");
			
			

			
			System.out.println("Data Displayed Successfully");
			System.out.println();
			
			System.out.println("Employee Id is: "+EmpID);
			System.out.println("Employee name is: "+Empname);
			System.out.println("Employee email is: "+Empemail);
			System.out.println("Employee Phone no. is: "+Empphone);
			
			
		}
		
		
		
		
		
		
		
	}catch(SQLException | ClassNotFoundException e )
	{
		e.printStackTrace();
	}
	finally{
		try {
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


}
}
