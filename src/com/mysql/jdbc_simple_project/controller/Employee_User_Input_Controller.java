package com.mysql.jdbc_simple_project.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_User_Input_Controller {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			int id=sc.nextInt();
			String name=sc.next();
			String email=sc.next();
			
			long phone=sc.nextLong();
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
			String insertQuery="insert into employee values('"+id+"','"+name+"','"+email+"','"+phone+"')";
			
			st.execute(insertQuery);
			
			
			System.out.println("Data Inserted Successfully");
			
			
			
			
}catch(SQLException | ClassNotFoundException e )
{
			e.printStackTrace();
}
finally{
			try {
				conn.close();
				sc.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
}
		}


}

