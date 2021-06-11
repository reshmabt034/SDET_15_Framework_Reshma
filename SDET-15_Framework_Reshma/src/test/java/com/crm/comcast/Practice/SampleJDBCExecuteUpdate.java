package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	
	public void executeUpdateJDBC() throws SQLException
	{
		
		//step 1 : Register to the database
		
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef);
		
		//Step 2 : Get connection with database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_15", "root", "root");
		
		//Step 3 : Issue Create statement
		Statement statmnt = conn.createStatement();
		
		//Step 4 : Execute Update
		int result = statmnt.executeUpdate("Insert into employee values('Ranjita',4567984,'Jaipur');");
		
		if(result == 1) {
			System.out.println("Query Successfull - 1 row updated");
		}
		else
		{
			System.out.println("Query failed");
		}
		
		//Step 5 : close Database
		conn.close();
		System.out.println("Database successfully closed");
		
	}
	

}
