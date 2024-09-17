package com.mysql.jdbc_simple_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_Delete_Controller {
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
		String Delete="delete from employee where id=235";
		
		st.executeUpdate(Delete);
		
		
		System.out.println("Data Deleted Successfully");
		
		
		
		
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