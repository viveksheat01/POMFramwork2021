package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementsUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementsUtils elementutil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By prodMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By prodPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementsUtils(driver);
	}

	public String getProductHeaderText() {

		return elementutil.doGetText(productHeader);

	}

	public int getProductImagesCount() {
		return elementutil.waitForElementsVisible(productImages, Constants.DEFAULT_TIME_OUT).size();
	}

	public Map<String, String> getProductMetaData() {
		Map<String, String> prodMap = new HashMap<String, String>();
		String productName = elementutil.doGetText(productHeader);
		prodMap.put("productname", productName);
		getProdMetaData(prodMap);
		getProdPriceData(prodMap);
		return prodMap;
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: Out Of Stock
	private void getProdMetaData(Map<String, String> prodMap) {
		List<WebElement> metaList = elementutil.getElements(prodMetaData);
		for (WebElement e : metaList) {
			String metaText = e.getText();
			String metaKey = metaText.split(":")[0].trim();
			String metaValue = metaText.split(":")[1].trim();
			prodMap.put(metaKey, metaValue);
		}
	}

	private void getProdPriceData(Map<String, String> prodMap) {
		List<WebElement> priceList = elementutil.getElements(prodPriceData);
		String actPrice = priceList.get(0).getText().trim();
		String exTaxPrice = priceList.get(1).getText().trim();// Ex Tax: $2,000.00
		prodMap.put("price", actPrice);
		prodMap.put("ExTaxPrice", exTaxPrice.split(":")[1].trim());
	}

}
