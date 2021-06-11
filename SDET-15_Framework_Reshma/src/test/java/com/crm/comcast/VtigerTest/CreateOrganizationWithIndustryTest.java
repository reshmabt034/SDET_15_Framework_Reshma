package com.crm.comcast.VtigerTest;

import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.XMLFileUtility;

public class CreateOrganizationWithIndustryTest 
{
	@Test
	
	public void CreateOrganizationWithIndustry() throws DocumentException 
	{
	
		
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
		
		//navigate to organizations
	    driver.findElement(By.linkText("Organizations")).click();
	    
	    //navigate to create organization
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
	    //enter mandatory fields and create organization with industry dropdown, select industry type as education 
	    driver.findElement(By.name("accountname")).sendKeys("SkillRary_"+random);
	    
	     WebElement selectDropdown = driver.findElement(By.cssSelector("select[name='industry']"));
	     
	     Select dropdown = new Select(selectDropdown);
	     dropdown.selectByValue("Education");
	     
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	   //validate
	        String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	        Assert.assertTrue(successMsg.contains("SkillRary"));
	        System.out.println(successMsg);
	     
//	     close browser
	     //driver.close();

}
	
}

