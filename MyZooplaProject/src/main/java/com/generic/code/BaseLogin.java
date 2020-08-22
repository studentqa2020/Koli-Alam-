package com.generic.code;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.BaseConfig;

import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class BaseLogin {
	
	protected static WebDriver driver;
	public static void GetLogin() throws Throwable {
		
		
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	// open the browser
	driver.get(BaseConfig.getconfig("URL"));
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

public static void main(String[] args) throws Throwable {
	new BaseLogin().GetLogin();
}
}



