package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{

@Test
public void testValidLogin()
{
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUsername("admin@yourstore.com");
loginpage.enterPassword("admin");
loginpage.clickLoginBtn();
System.out.println("Title of the page is; " +driver.getTitle());
Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
}

}
