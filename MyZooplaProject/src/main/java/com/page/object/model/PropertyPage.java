package com.page.object.model;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyPage {

	public PropertyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//*[@type='text']")//"//*[@type='text']"
	private WebElement NewYork;

	public WebElement getNewYork() {
		return NewYork;

	}

	@FindBy(xpath = "//*[@class='button button--primary']") //"//*[@value='Search']
	private WebElement Search;

	public WebElement getSearch() {
		return Search;
	}
	
//	@FindBy(xpath = "//a[@class='listing-results-price text-price']")////*[@class='listing-results-price text-price']"
//	private List<WebElement> Value;
//	
//	public List<WebElement> getValue() {
//		return Value;
//	}
	
	@FindBy(xpath = "//*[@class='listing-results-price text-price']") //"(//img[@alt='Parkmove'])[1]"
	private List<WebElement> Homeprice;
	
	public List<WebElement> getHomeprice() {
		return Homeprice;
	}
	@FindBy(xpath="//img[@class='js-lazy-loaded']")////img[@class='js-lazy-loaded']
	private WebElement PropertyLogo;
	
	public WebElement getPropertyLogo() {
		return PropertyLogo;
	}
	@FindBy(xpath="(//h4[@class='ui-agent__name'])[1]")
	private WebElement AgentName;
	
	public WebElement getAgentName() {
		return AgentName;
	}
	
	@FindBy(xpath="(//*[@class='ui-link'])[4]") ////*[@class='ui-link'])[4]"
	private WebElement AgentPhoneNum;
	
	@FindBy(xpath="//*[@id='search-submit']")
	private WebElement searchPropertyBtn;
	
	public WebElement getSearchPropertyBtn() {
		return searchPropertyBtn;
	}

	public WebElement getAgentPhoneNum() {
		return AgentPhoneNum;
	}
	
	@FindBy(xpath="//*[@class='css-1mjljx5 eson0er0']//*[text()='My Zoopla']") // "//*[@class='css-1mjljx5 eson0er0']//*[text()='My Zoopla']"
	private WebElement MyZooplaBtn;
	
	public WebElement getMyZooplaBtn() {
		return MyZooplaBtn;
	}
	
	@FindBy(xpath="(//div[@content='Sign out'])[1]")  //"(//div[@content='Sign out'])[1]"
	private WebElement SignOut;
	
	public WebElement getSignOut() {
		return SignOut;
	}
	

	
}