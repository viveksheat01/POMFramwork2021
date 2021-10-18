package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementsUtils;

public class RegisterationPage {

	private WebDriver driver;
	private ElementsUtils elementutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confrimPassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterationPage(WebDriver driver) {
		elementutil = new ElementsUtils(driver);
	}

	public boolean resiteration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		fillRegFrom(firstName, lastName, email, telephone, password);
		selectSubOption(subscribe);
		selectAgreementAndContinue();
		return getRegistationStatus();

	}

	public boolean getRegistationStatus() {
		String meg = elementutil.doGetText(sucessMessg);
		if (meg.contains(Constants.RESITER_SUCESS_MESSAGE)) {
			elementutil.doClick(logoutLink);
			elementutil.doClick(registerLink);

			return true;

		}
		return false;

	}

	public void selectAgreementAndContinue() {

		elementutil.doClick(agreeCheckBox);
		elementutil.doClick(continueButton);
	}

	private void selectSubOption(String subscribe) {
		if (subscribe.equalsIgnoreCase("yes")) {
			elementutil.doClick(subscribeYes);

		} else {
			elementutil.doClick(subscribeNo);
		}

	}

	private void fillRegFrom(String firstName, String lastName, String email, String telephone, String password) {
		elementutil.doSendKeys(this.firstName, firstName);
		elementutil.doSendKeys(this.lastName, lastName);

		elementutil.doSendKeys(this.email, email);

		elementutil.doSendKeys(this.telephone, telephone);

		elementutil.doSendKeys(this.password, password);

		elementutil.doSendKeys(this.confrimPassword, password);

	}

}
