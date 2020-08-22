package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.page.object.model.PropertyPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class CucumberCode {
	
	public static LoginPage Login;
	public static PropertyPage MyProperty;
	
	public static WebDriver setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		return driver;

	}
	
	public static void getURL(WebDriver driver) throws Throwable {
		driver.get(BaseConfig.getconfig("URL"));
	}
	
	public static void acceptCookies(WebDriver driver) {
		Login = new LoginPage(driver);
		System.out.println(driver.getTitle());

		// click cookie
		Login.getCookies();
		Login.getCookies().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}	
	
	public static void clickSignInLink(WebDriver driver) {
		new Highlighter().getcolor(driver, Login.getSignBnt());
		Login.getSignBnt().click();

		System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());

	}
	public static void enterUserName(WebDriver driver) throws Throwable {
		Wait.getExplicitWaitClicable(driver, Login.getEmail());
		new Highlighter().getcolor(driver, Login.getEmail(), "yellow");
		Login.getEmail().sendKeys(BaseConfig.getconfig("Email"));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	public static void enterPassword(WebDriver driver) throws Throwable {
		new Highlighter().getcolor(driver, Login.getPassword(), "black");
		Login.getPassword().sendKeys(BaseConfig.getconfig("Password"));
		// Thread.sleep(3000);
		Wait.getExplicitWaitClicable(driver, Login.getPassword());
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
		
	}
	public static void clickLogIn(WebDriver driver) {
		new Highlighter().getcolor(driver, Login.getSubmited(), "green");
		Login.getSubmited().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	public static void searchCity(WebDriver driver) throws Throwable {
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MyProperty = new PropertyPage(driver);
		Wait.getExplicitWaitClicable(driver, MyProperty.getNewYork());

		// findNewYork
		new Highlighter().getcolor(driver, MyProperty.getNewYork(), "yellow");
		MyProperty.getNewYork().sendKeys(BaseConfig.getconfig("Loaction"));
		new Highlighter().getcolor(driver, MyProperty.getSearch(), "green");
		MyProperty.getSearch().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	public static void getProperty(WebDriver driver) throws Throwable {
		
			//MyProperty.getHomeprice().get(4).click();
		String[] Price;
		List<Integer> Myprice = new ArrayList<>();
		for (int i = 0; i < MyProperty.getHomeprice().size(); i++) {

			Price = MyProperty.getHomeprice().get(i).getText().split(" ");
			Myprice.add(Integer.parseInt(Price[0].replace("£", "").replace(",", "").trim()));

		}
		System.out.println("House Price" + Myprice);
		Collections.sort(Myprice);
		System.out.println("House Price Sorted ASC" + Myprice);
		Collections.reverse(Myprice);
		System.out.println("House Price DESC" + Myprice);
	
		//Wait.getExplicitWaitClicable(driver, MyProperty.getHomeprice().get(4));
		Thread.sleep(5000);
		
		// 5thProperty
		MyProperty.getHomeprice().get(4).click();

	}
	
	public static void validateAgentInfo(WebDriver driver) {
		if(MyProperty.getPropertyLogo().isDisplayed()) {
			System.out.println(" Logo Is Present");
		}else {
	System.out.println(" Logo Is not Present");
				
		}
		
		//Agent Name
		System.out.println(" Agent Name"+MyProperty.getAgentName().getText());
		//Agent PhoneNumber
		System.out.println(" Agent Phone Num"+MyProperty.getAgentPhoneNum().getText());
		//ScreenShot
		TakeAppScreenShot.captureScreenShot(driver, "Agenr Information");

	}
	
	public static void getSignOut(WebDriver driver) {
		Actions signOut = new Actions(driver);
		signOut.moveToElement(MyProperty.getMyZooplaBtn()).build().perform();
		Highlighter.getcolor(driver,MyProperty.getMyZooplaBtn(),"red");
		signOut.moveToElement(MyProperty.getSignOut()).build().perform();
		Highlighter.getcolor(driver, MyProperty.getSignOut(), "yellow");
		TakeAppScreenShot.captureScreenShot(driver, "Sign Out");
		MyProperty.getSignOut().click();

	}
	
	public static void ClickSearch (WebDriver driver){
		
		
	}
	
}
