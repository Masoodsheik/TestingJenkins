package com.Geico;

import org.testng.annotations.Test;

import PageObjects.LoginPage;


public class TC_Login extends Baseclass {

	@Test
	public void LoginTest() {

		
		logger.info("Url is Open orangehrmlive");
		LoginPage login = new LoginPage(driver);
		login.SetUserName(UserName);
		String getUname = login.getUserName();
		System.out.println(getUname);
		login.SetPassword(Password);;
		login.ClickSubmit();
		logger.info("Application is successfully login");
		if (driver.getTitle().equalsIgnoreCase(pageTitle)) {

		//	Assert.assertTrue(true);
			logger.info("Login Test Passed");

		} else {
			CaptureScreenshot(driver, "LoginTest");
			//Assert.assertTrue(true);
			logger.info("Login test fail");
		}

	}

}
