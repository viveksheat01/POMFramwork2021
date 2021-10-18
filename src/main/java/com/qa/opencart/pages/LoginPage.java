package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementsUtils;

public class LoginPage {

	// 1. by locators - Page obje4ct

	private WebDriver driver;
	private ElementsUtils elementUtil;

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotePassword = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	// 2. page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementsUtils(driver);
	}

	// 3. page actions /methods/features

	public String getloginPagetitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isForgotPasswordExist() {
		return elementUtil.doIsDiplayed(forgotePassword);
	}

	public boolean isRegisterLinkExist() {

		return elementUtil.doIsDiplayed(registerLink);
	}

	public AccountPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountPage(driver);

	}

	public RegisterationPage navigateToregistrationPage() {
		elementUtil.doClick(registerLink);
		return new RegisterationPage(driver);

	}
}
