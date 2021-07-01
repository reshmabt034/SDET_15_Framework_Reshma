package com.crm.comcast.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {
	
	static int count = 1;
	@Test
	public void dryRun() {
		System.out.println(count++);
		Assert.assertTrue(false);
	}

}
