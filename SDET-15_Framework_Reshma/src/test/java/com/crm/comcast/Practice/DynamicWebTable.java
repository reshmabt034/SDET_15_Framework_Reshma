package com.crm.comcast.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.XMLFileUtility;

public class DynamicWebTable {
	
	@Test
	
	public void handlingDynamicWT() throws DocumentException {
		
		WebDriver driver;
		
		XMLFileUtility xmlLib = new XMLFileUtility();
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
	    
	    //click on all the check boxex
	    List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
	    /*
	    for(int i=1; i<list.size() ;i++)
	    {
	    	list.get(i).click();
	    }*/
	    
	    //click on last check box
//	    list.get(list.size()-1).click();
	    
	    //click on 3rd row check box
//	    driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input")).click();
	    
	    //select only first 5 check boxes
	    for(int i=1; i<=5; i++){
	    	list.get(i).click()	;
	    }
		
	    //to print all organization name in console
//	    List<WebElement> wd = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
//	    
//	    for(WebElement w : wd) {
//	    	System.out.println(w.getText());
//	    }
//	    
//	    
	    
	    //identify skillrary and delete it
	    
	   List<WebElement> del = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	   String expData = "Skillrary";
	   int actData=0;
	   
	   for(WebElement e : del) {
		   String actData1 = e.getText();
		   if(actData1.equalsIgnoreCase(expData)) {
			   break;
		   }
		   actData++;
	   }
	   System.out.println(actData);
	   driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(actData+2)+"]/td[8]/a[.='del']")).click();
	   
	   driver.switchTo().alert().accept();
	  
	}

}
