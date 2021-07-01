package com.crm.comcast.Practice;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.DatabaseUtility;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.JSONFileUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.XMLFileUtility;

public class DemoRead {
	
	@Test
	public void demoProperty() throws Throwable
	{
		PropertyFileUtility pLib=new PropertyFileUtility();
		
		JSONFileUtility jsonLib = new JSONFileUtility();
		
		XMLFileUtility xmlLib = new XMLFileUtility();
		
		DatabaseUtility dbLib = new DatabaseUtility();
		
		ExcelUtility eLib = new ExcelUtility();
		
		String USERNAME = pLib.readDataFromPropertyFile("username");
		System.out.println(USERNAME);
		
		String URL = jsonLib.readDataFromJSON("url");
		System.out.println(URL);
		
		String PASSWORD = xmlLib.readDataFromXml("password");
		System.out.println(PASSWORD);
		
		dbLib.connectDataBase();
		String value = dbLib.executeQueryAndGetData("select * from employee;", 1, "Chaitra");
		System.out.println(value);
		dbLib.closeDB();
		
		String val = eLib.getExcelData("sheet1", 1, 2);
		System.out.println(val);
		
		String var = eLib.getExcelData("sheet1", "TC_01", "OrgName");
		System.out.println(var);
		
	}
	
}


