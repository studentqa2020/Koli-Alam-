package com.step.def;

import org.openqa.selenium.WebDriver;

import com.cucumber.BaseLoginCucumber;
import com.cucumber.HomeSelectionCucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("User is on Zoopla Website")
	public void user_is_on_Zoopla_Website() throws Throwable {
		driver = BaseLoginCucumber.setup();
	}

	@When("User click on Signin Buton")
	public void user_click_on_Signin_Buton() {
		BaseLoginCucumber.clickSignOnLink(driver);
	}

	@When("User Enters Credentials and Submit Login")
	public void user_Enters_Credentials_and_Submit_Login() throws Throwable {
		BaseLoginCucumber.getLogin(driver);
	}

	@Then("User is on Search Property page")
	public void user_is_on_Search_Property_page() {
		System.out.println(driver.getTitle());
	}

	@When("User Enters City Name and Search Properties")
	public void user_Enters_City_Name_and_Search_Properties() throws Throwable {
		HomeSelectionCucumber.searchProperty(driver);
	}

	@Then("User gets the Properties page")
	public void user_gets_the_Properties_page() {
	    System.out.println(driver.getTitle());
	}

	@When("User Display all Properties prices in desc order")
	public void user_Display_all_Properties_prices_in_desc_order() throws Throwable {
		HomeSelectionCucumber.displayPropertyPrice(driver);
	}

	@When("User Selects Fifth Property")
	public void user_Selects_Fifth_Property() {
		HomeSelectionCucumber.clickFifthProperty(driver);
	}

	@When("User Verify Logo")
	public void user_Verify_Logo() {
		HomeSelectionCucumber.checkLogo(driver);
	}

	@When("User Display Agent name and Phone Num")
	public void user_Display_Agent_name_and_Phone_Num() {
		HomeSelectionCucumber.showContactInfo(driver);
	}

	@When("User clicks on Sign out button")
	public void user_clicks_on_Sign_out_button() {
		HomeSelectionCucumber.signOut(driver);
	}

	@Then("User Signs Out")
	public void user_Signs_Out() {
	    System.out.println(driver.getTitle());
	    driver.quit();
	}

}
