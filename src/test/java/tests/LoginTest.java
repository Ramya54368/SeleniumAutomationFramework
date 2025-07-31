package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		Log.info("Starting Login Test.....");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding Credentials.....");
		loginpage.enterUsername("admin@yourstore.com");
		loginpage.enterPassword("admin");
		loginpage.clickLoginBtn();
		System.out.println("Title of the page is; " + driver.getTitle());
		Log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
	}

}
