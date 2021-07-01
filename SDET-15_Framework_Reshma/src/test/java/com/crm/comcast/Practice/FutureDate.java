package com.crm.comcast.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FutureDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click();
		
//		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
//		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
//		
//		src.sendKeys("Mumbai");
//		driver.findElement(By.xpath("//div[contains(text(), 'BOM')]")).click();
//		
//		Thread.sleep(1000);
//		
//		dest.sendKeys("Chennai");
//		driver.findElement(By.xpath("//div[contains(text(), 'MAA')]")).click();
//		
//		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(1000);
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Sat Oct 02 2021']")).click();
				break;
			}
			
			catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}

}
