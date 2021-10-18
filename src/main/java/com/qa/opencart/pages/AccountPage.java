package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementsUtils;

public class AccountPage {

	private WebDriver driver;
	private ElementsUtils elementutil;

	private By search = By.name("search");
	private By logoutLink = By.linkText("Logout");
	private By accounthaeder = By.cssSelector("div#content h2");
	private By searchIcon = By.cssSelector("div#search span");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementsUtils(driver);
	}

	public String getaccPageTitle() {
		return elementutil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.ACC_PAGE_TITLE);
	}

	public boolean islogoutExist() {
		return elementutil.doIsDiplayed(accounthaeder);

	}

	public boolean isSearchFiealExist() {
		return elementutil.doIsDiplayed(search);
	}

	public List<String> getAccountSecList() {
		List<WebElement> secList = elementutil.getElements(accounthaeder);
		List<String> secHeaderList = new ArrayList<String>();
		for (WebElement e : secList) {
			secHeaderList.add(e.getText());

		}
		return secHeaderList;

	}

	public ResultPage doSearch(String Productname) {

		System.out.println("product name " + Productname);
		elementutil.doSendKeys(search, Productname);
		elementutil.doClick(searchIcon);

		return new ResultPage(driver);

	}

}
