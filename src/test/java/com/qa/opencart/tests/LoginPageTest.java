package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {

		String title = loginpage.getloginPagetitle();

		System.out.println(" actull page titele is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {

		String url = loginpage.getLoginPageUrl();

		System.out.println(" actull page titele is " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}

	@Test
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginpage.isForgotPasswordExist());
	}

	@Test(enabled = false)
	public void registerLinkTest() {
		AssertJUnit.assertTrue(loginpage.isRegisterLinkExist());

	}

	@Test
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

}
