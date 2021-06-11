package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	
	public void executeQuery() throws SQLException
	{
		// Step 1 : Register to the Database
		Driver drvRef = new Driver();
		DriverManager.registerDriver(drvRef);
		
		// Step 2 : Get connection with Database - provide database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_15", "root", "root");
		
		//Step 3 : Issue create statement
		Statement statmnt = conn.createStatement();
		
		//Step 4 : Execute Query
		ResultSet result = statmnt.executeQuery("select * from employee; ");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		
		//Step 5 : close Database
		conn.close();
		
	}

}
