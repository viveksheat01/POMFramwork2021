package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void accPageTitleTest() {
		String title = accPage.getaccPageTitle();
		System.out.println("Acc page title is :" + title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
	}

	@Test
	public void accPageLogoutLinkTest() {
		Assert.assertTrue(accPage.islogoutExist());
	}

	@Test
	public void accPageSearchTest() {
		Assert.assertTrue(accPage.isSearchFiealExist());
	}

	@Test
	public void accPageSecheaderTest() {
		List<String> actsecList = accPage.getAccountSecList();

		System.out.println(actsecList);

		Assert.assertEquals(actsecList, Constants.EXP_ACCOUNTS_SECTIONS_LIST);

	}

	@DataProvider
	public Object[][] productdata() {
		return new Object[][] {

				{ "macbook" }, { "iMac" }, { "Apple" }

		};
	}

	@Test(dataProvider = "productdata")
	public void SearchTest(String productName) {

		resultpage = accPage.doSearch(productName);
		Assert.assertTrue(resultpage.getSearchProductListCount() > 0);

	}

	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] {

				{ "macbook", "Macbook Pro" }, { "iMac", "iMac" }, { "Apple", "Apple Cinema 30\"" }

		};
	}

	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		resultpage = accPage.doSearch(productName);

		resultpage.selectProduct(mainProductName);
	}

}
