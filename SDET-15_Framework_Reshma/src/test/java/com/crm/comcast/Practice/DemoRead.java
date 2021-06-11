package com.crm.comcast.Practice;

import org.testng.annotations.Test;

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
		
		String USERNAME = pLib.readDataFromPropertyFile("username");
		System.out.println(USERNAME);
		
		String URL = jsonLib.readDataFromJSON("url");
		System.out.println(URL);
		
		String PASSWORD = xmlLib.readDataFromXml("password");
		System.out.println(PASSWORD);
		
	}
	
}


