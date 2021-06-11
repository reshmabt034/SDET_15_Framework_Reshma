package com.crm.comcast.GenericUtils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains methods related to database
 * 
 * @author Reshma
 *
 */
public class DatabaseUtility {
	
	Connection conn = null;
	ResultSet result = null;
	
	/**
	 * This method will establish connection with database
	 * @throws SQLException 
	 * 
	 */
	
	public void connectDataBase() throws SQLException {
		Driver drvRef;
		try
		{
		drvRef = new Driver();
		DriverManager.registerDriver(drvRef);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_15", "root", "root");
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		/**
		 * This method will close DB connection
		 * @thows 
		 * 
		 */
	
		public void closeDB() throws SQLException {
		// TODO Auto-generated method stub
		conn.close();
		}
		
		/**
		 * 
		 * @param query
		 * @param columnName
		 * @param expData
		 * @return
		 * @throws SQLException
		 */
		
		public String executeQueryAndGetData(String query, int columnName, String expData) throws SQLException {
			
			boolean flag = false;
			result = conn.createStatement().executeQuery(query);
			while(result.next())
			{
				if(result.getString(columnName).equalsIgnoreCase(expData)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println(expData + "data verified in database");
				return expData;
			}
			else {
				System.out.println(expData + "data not verified");
				return expData;
			}
		}
		
		public ResultSet readDataFromDatabase() {
			//step1
			//step2
			//step3
			//step4
			return result;
		
		}
}



