package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registationSetup() {

		registerationPage = loginpage.navigateToregistrationPage();

	}

	public String getRandomNumber() {
		Random random = new Random();
		String email = "testautomation" + random.nextInt(100000) + "@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.REGITER_SHEET_NAME);
		return data;

	}

	@Test(dataProvider = "getRegTestData")
	public void registationTest(String firstname, String lastname, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(
				registerationPage.resiteration(firstname, lastname, getRandomNumber(), telephone, password, subscribe));

	}

}
