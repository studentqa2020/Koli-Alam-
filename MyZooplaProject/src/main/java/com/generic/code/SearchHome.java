package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertyPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class SearchHome  extends BaseLogin  {
	
	
	public static void getHomeprice() throws Throwable {

		GetLogin();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyPage MyProperty = new PropertyPage(driver);
		Wait.getExplicitWaitClicable(driver, MyProperty.getNewYork());

		// findNewYork
		new Highlighter().getcolor(driver, MyProperty.getNewYork(), "yellow");
		MyProperty.getNewYork().sendKeys(BaseConfig.getconfig("Loaction"));

		// ClickSearch
		Highlighter.getcolor(driver, MyProperty.getSearch(), "green");
		MyProperty.getSearch().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		// Get the properties
		
		// House price
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
		
		
		// SelectLogo
//		
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
		// SignOut
		Actions signOut = new Actions(driver);
		signOut.moveToElement(MyProperty.getMyZooplaBtn()).build().perform();
		Highlighter.getcolor(driver,MyProperty.getMyZooplaBtn(),"red");
		signOut.moveToElement(MyProperty.getSignOut()).build().perform();
		Highlighter.getcolor(driver, MyProperty.getSignOut(), "yellow");
		TakeAppScreenShot.captureScreenShot(driver, "Sign Out");
		MyProperty.getSignOut().click();
		
	}
//	public static void main(String[] args) throws Throwable {
//		getHomeprice();
//	}


}
