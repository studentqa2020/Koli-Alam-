package com.smoke.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testng.code.BaseLoginTestng;
import com.testng.code.HomeSelectionTestng;

public class SmokeTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setupBrowser() throws Throwable {
		driver = BaseLoginTestng.setup();
	}
	
	@Test
	public void test() throws Throwable {		
		// login,search property, sort prices, get Agent info and signout
		BaseLoginTestng.getLogin(driver);		
	}
	@Test
	public void test2() throws Throwable {
		HomeSelectionTestng.getHomeSelection(driver);
	}
	@AfterTest
	public void tearOff() {
		driver.quit();
	}

}
