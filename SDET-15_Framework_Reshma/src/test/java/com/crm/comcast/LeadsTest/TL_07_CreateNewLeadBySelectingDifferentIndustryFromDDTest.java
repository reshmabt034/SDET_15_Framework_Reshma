
package com.crm.comcast.LeadsTest;

import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.XMLFileUtility;

public class TL_07_CreateNewLeadBySelectingDifferentIndustryFromDDTest {
	
	
	@Test
	public void CreateNewLeadIndustry() throws DocumentException {
		
		WebDriver driver;
		XMLFileUtility xmlLib = new XMLFileUtility();
		//	PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
	
		int random = jLib.getRandomNumber();
		String URL = xmlLib.readDataFromXml("url");
		String USERNAME = xmlLib.readDataFromXml("username");
		String PASSWORD = xmlLib.readDataFromXml("password");
		String BROWSER = xmlLib.readDataFromXml("browser");
    
		//launch browser
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
    
		//navigate to the url
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
    
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//navigate to create lead
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//enter mandatory fields and create lead by selecting different industry from Dropdown
		driver.findElement(By.name("lastname")).sendKeys("Patil");
		driver.findElement(By.name("company")).sendKeys("PRODUCTITServices");
		
		WebElement selectdropdown = driver.findElement(By.name("industry"));
		
		Select dropdown = new Select(selectdropdown);
		dropdown.selectByValue("Biotechnology");
		
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		//validate
        String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        Assert.assertTrue(successMsg.contains("Patil"));
        System.out.println(successMsg);
		
//		sign out of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
//		act.moveToElement().perform();
		
		
		
		
		
		
		
		
		
	}

}

