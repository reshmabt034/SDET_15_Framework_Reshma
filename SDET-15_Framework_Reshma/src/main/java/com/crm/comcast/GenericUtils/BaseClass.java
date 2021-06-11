package com.crm.comcast.GenericUtils;

import java.sql.SQLException;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public XMLFileUtility xLib = new XMLFileUtility();
	public JSONFileUtility jsLib = new JSONFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriver driver;
	
	
	@BeforeSuite
	public void makeDBConnection() throws Throwable {
		
		dLib.connectDataBase();
		System.out.println("======Make Database Connection");
	}

	@BeforeClass
	public void launchBrowser() throws Throwable {
		String BROWSER = xLib.readDataFromXml("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable {
		String USERNAME = xLib.readDataFromXml("username");
		String PASSWORD = xLib.readDataFromXml("password");
		String URL = xLib.readDataFromXml("url");
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
}
