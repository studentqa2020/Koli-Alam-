package com.testng.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class BaseLoginTestng {
	
	public static WebDriver setup() throws Throwable {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// open the browser
		driver.get(BaseConfig.getconfig("URL"));
		return driver;
	}
	public static void getLogin(WebDriver driver) throws Throwable {
		LoginPage Login = new LoginPage(driver);
		System.out.println(driver.getTitle());
	
		// click cookie
		Login.getCookies();
		Login.getCookies().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
		// click Sign_In
		new Highlighter().getcolor(driver, Login.getSignBnt());
		Login.getSignBnt().click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
		// click Email
		
		Wait.getExplicitWaitClicable(driver, Login.getEmail());
		new Highlighter().getcolor(driver, Login.getEmail(), "yellow");
		Login.getEmail().sendKeys(BaseConfig.getconfig("Email"));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
		// Click Password
		new Highlighter().getcolor(driver, Login.getPassword(), "black");
		Login.getPassword().sendKeys(BaseConfig.getconfig("Password"));
		// Thread.sleep(3000);
		Wait.getExplicitWaitClicable(driver, Login.getPassword());
	
		// ScreenShort
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
	
		// Click Sign
		new Highlighter().getcolor(driver, Login.getSubmited(), "green");
		Login.getSubmited().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

}
