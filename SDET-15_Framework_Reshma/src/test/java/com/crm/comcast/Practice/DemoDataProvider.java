package com.crm.comcast.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
	
	@DataProvider
	
	public Object[][] provideData()
	{
		//declare a 2D-Object array
		Object[][] data = new Object[][]{{"iPhone",3000,6.4},{"Tablet",5000,5.6}};
		
//		//add values into the ate provider
//		data[0][0] = "iPhone";
//		data[0][1] = 3000;
//		data[0][2] = 6.4;
//		
//		data[1][0] = "Tablet";
//		data[1][1] = 5000;
//		data[1][2] = 5.6;
		
		return data;		
	}
	//call the data provider in the test script
	@Test(dataProvider = "provideData")
	
	public void readData(String phone, int price, double version) {
		System.out.println("phone is "+phone +"\nprice is "+price+"\nversion is "+version);
	}
	

}
