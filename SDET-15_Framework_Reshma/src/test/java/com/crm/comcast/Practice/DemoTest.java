package com.crm.comcast.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void demoTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
//		LoginPage lp = new LoginPage(driver);
//		lp.login("admin","admin");
	}

}
