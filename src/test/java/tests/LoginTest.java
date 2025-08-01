package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManger;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		Log.info("Starting Login Test.....");
		test = ExtentReportManger.createTest("Login Test");
		test.info("Navigating to Login page");
		LoginPage loginpage = new LoginPage(driver);

		Log.info("Adding Credentials.....");
		test.info("Adding crendentials");
		loginpage.enterUsername("admin@yourstore.com");
		loginpage.enterPassword("admin");
		test.info("clicking on login button");
		loginpage.clickLoginBtn();
		System.out.println("Title of the page is; " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("verifying page title");

		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("login successfully");
	}
	@Test
	public void testLoginWithInvalidCredentials() {
		Log.info("Starting Login Test.....");
		test = ExtentReportManger.createTest("Login Test with invalid credentials");
		test.info("Navigating to Login page");
		LoginPage loginpage = new LoginPage(driver);

		Log.info("Adding Credentials.....");
		test.info("Adding crendentials");
		loginpage.enterUsername("admin123@yourstore.com");
		loginpage.enterPassword("admin");
		test.info("clicking on login button");
		loginpage.clickLoginBtn();
		System.out.println("Title of the page is; " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("verifying page title");

		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("login successfully");
	}
	

}
