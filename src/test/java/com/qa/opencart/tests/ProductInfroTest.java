package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfroTest extends BaseTest {

	@BeforeClass
	public void productInfroPageSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void ProductHeaderTest() {

		resultpage = accPage.doSearch("Macbook");
		productInfro = resultpage.selectProduct("MacBook Pro");
		String actHeader = productInfro.getProductHeaderText();

		System.out.println(actHeader);

		Assert.assertEquals(actHeader, "MacBook Pro");
	}

	@DataProvider
	public Object[][] getImageData() {
		return new Object[][] {

				{ "macbook", "MacBook Pro", 4 }, { "iMac", "iMac", 3 }, { "Apple", "Apple Cinema 30\"", 6 }

		};

	}

	@Test(dataProvider = "getImageData")
	public void productImgCountTest(String ProductName, String mainProductName, int imgCount) {
		resultpage = accPage.doSearch(ProductName);
		productInfro = resultpage.selectProduct(mainProductName);
		Assert.assertEquals(productInfro.getProductImagesCount(), imgCount);

	}

	@Test
	public void productMetaDataTest() {
		resultpage = accPage.doSearch("macbook");
		productInfro = resultpage.selectProduct("MacBook Pro");
		Map<String, String> actProdMap = productInfro.getProductMetaData();
		actProdMap.forEach((k, v) -> System.out.println(k + ":" + v));

		softAssert.assertEquals(actProdMap.get("productname"), "MacBook Pro");
		softAssert.assertEquals(actProdMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProdMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProdMap.get("price"), "$2,000.00");
		softAssert.assertAll();

	}

}
