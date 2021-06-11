package com.crm.comcast.Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CurrentDate {
	
	public static void main(String[] args) throws InterruptedException {
		
		Date dateobj = new Date();
		
		String todaysdate = dateobj.toString();
		String[] arr = todaysdate.split(" ");
		
		String day = arr[0];
		String month = arr[1];
		String date = arr[2];
		String year = arr[5];
		
		String traveldate = day+" "+month+" "+date+" "+year;
		
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//open website
		driver.get("https://www.makemytrip.com/");
		
		//Maximize window
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		Actions act = new Actions(driver);
		
		act.moveByOffset(10, 10).click();
		
	
	
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		//Enter source as Mumbai
		src.sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
		
		Thread.sleep(1000);
		
		//Enter destination AS Chennai
		dest.sendKeys("Chennai");
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Thread.sleep(1000);
				
		driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
	}

}
