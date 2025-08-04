package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManger;
import utils.Log;

public class LoginTest extends BaseTest {
	// Function to get test data from Excel
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = "C:\\Users\\ramya\\eclipse-workspace\\selenium-framework\\testdata\\TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0);// username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1);// password

		}
		ExcelUtils.closeExcel();
		return data;

	}

	@DataProvider(name="LoginData2")
   public Object[][] getData()
   {
	return new Object[][]
			{
		{"user1","pass1"},
		{"user1","pass1"},
		{"user1","pass1"}
		
			};
	 
	   
	   
   }

	//@Test(dataProvider = "LoginData2")
	//@Test
	@Parameters({"username","password"})

	public void testValidLogin(String username, String password) {
		Log.info("Starting Login Test.....");
		test = ExtentReportManger.createTest("Login Test " + username);
		test.info("Navigating to Login page");

		LoginPage loginpage = new LoginPage(driver);

		Log.info("Adding Credentials.....");
		test.info("Adding crendentials");

		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		test.info("clicking on login button");
		loginpage.clickLogin();

		System.out.println("Title of the page is; " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("verifying page title");

		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("login successfully");
	}
//	@Test
//	public void testLoginWithInvalidCredentials() {
//		Log.info("Starting Login Test.....");
//		test = ExtentReportManger.createTest("Login Test with invalid credentials");
//		test.info("Navigating to Login page");
//		LoginPage loginpage = new LoginPage(driver);
//
//		Log.info("Adding Credentials.....");
//		test.info("Adding crendentials");
//		loginpage.enterUsername("admin123@yourstore.com");
//		loginpage.enterPassword("admin");
//		test.info("clicking on login button");
//		loginpage.clickLoginBtn();
//		System.out.println("Title of the page is; " + driver.getTitle());
//		Log.info("Verifying page title");
//		test.info("verifying page title");
//
//		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
//		test.pass("login successfully");
//	}
//	

}
