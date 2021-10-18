package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementsUtils;

public class ResultPage {

	private WebDriver driver;
	private ElementsUtils elementutil;

	private By Searchheader = By.cssSelector("div#content h1");
	private By productResult = By.cssSelector("div.caption a");

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementsUtils(driver);
	}

	public String getSearchHeaderName() {

		return elementutil.doGetText(Searchheader);

	}

	public int getSearchProductListCount() {

		return elementutil.waitForElementsVisible(productResult, Constants.DEFAULT_TIME_OUT).size();

	}

	public ProductInfoPage selectProduct(String mainProductName) {

		List<WebElement> searchList = elementutil.waitForElementsVisible(productResult, Constants.DEFAULT_TIME_OUT);

		for (WebElement e : searchList) {

			String text = e.getText();
			if (text.equals(mainProductName)) {
				e.click();
				break;

			}
		}

		return new ProductInfoPage(driver);

	}

}
