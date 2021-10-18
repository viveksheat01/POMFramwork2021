package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.Driverfactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterationPage;
import com.qa.opencart.pages.ResultPage;

public class BaseTest {

	public WebDriver driver;
	public Driverfactory df;
	public Properties prop;
	public LoginPage loginpage;
	public AccountPage accPage;
	public ResultPage resultpage;
	public ProductInfoPage productInfro;
	public RegisterationPage registerationPage;
	public SoftAssert softAssert;

	@BeforeTest
	public void setUp() {

		df = new Driverfactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
