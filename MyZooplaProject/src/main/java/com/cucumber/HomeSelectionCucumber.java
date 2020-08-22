package com.cucumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertyPage;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class HomeSelectionCucumber {
	
	static PropertyPage MyProperty;
	public static void searchProperty(WebDriver driver) throws Throwable {
		MyProperty = new PropertyPage(driver);	
		MyProperty.getNewYork().sendKeys(BaseConfig.getconfig("Location"));	
	//	System.out.println("Prperty Location"+BaseConfig.getconfig("Location"));
		MyProperty.getSearchPropertyBtn().click();

	}
	public static void displayPropertyPrice(WebDriver driver) throws Throwable {
		String [] Homeprice;
		List<Integer> AllPrices = new ArrayList<>();
		for(int i=0; i<MyProperty.getHomeprice().size();i++) {
			System.out.println("HOME PRICE= "+MyProperty.getHomeprice().get(i).getText());
			Homeprice = MyProperty.getHomeprice().get(i).getText().split(" ");
			AllPrices.add(Integer.parseInt(Homeprice[0].replace("£","").replace(",","").trim()));//.trim method removes white space
		}

		Collections.sort(AllPrices);
		Collections.reverse(AllPrices);
		System.out.println("Sorted Home Prices: "+AllPrices);
			
		Thread.sleep(3000);

	}
	public static void clickFifthProperty(WebDriver driver) {
		MyProperty.getHomeprice().get(4).click();
	}
	public static void checkLogo(WebDriver driver) {
		Wait.getExplicitWaitClicable(driver, MyProperty.getAgentName());
		
		if(MyProperty.getPropertyLogo().isDisplayed()) {
			System.out.println("Logo is available, See Screen Shot");
		} else {
			System.out.println("Logo is not avaialble");
		}

	}
	public static void showContactInfo(WebDriver driver) {
		System.out.println("Agent Name is: "+MyProperty.getAgentName().getText());
		System.out.println("Agent Phone # is: "+MyProperty.getAgentPhoneNum().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Agent Info with Logo");

	}
	
	public static void signOut(WebDriver driver) {
		Actions signOut = new Actions(driver);
		signOut.moveToElement(MyProperty.getMyZooplaBtn()).build().perform();
		//signOut.moveToElement(MyProperty.getSignOut()).build().perform();
		TakeAppScreenShot.captureScreenShot(driver, "User has signed out");
		MyProperty.getSignOut().click();
	}
	}
