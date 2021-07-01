package com.crm.comcast.Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class testNGDemo {
	
	@Test
	public void CreateUser() {
		System.out.println("User created succesfully");
		Reporter.log("User created");
	}
	
	@Test
	public void ModifyUser() {
		System.out.println("User succesfully modified");
		Reporter.log("Modify user");
	}
	
	@Test
	public void DeleteUser() {
		System.out.println("User deleted succesfully");
		
	}

}
