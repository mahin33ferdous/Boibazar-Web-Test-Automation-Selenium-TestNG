package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.LoginPage;

public class LoginTest extends BaseDriver{

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
	}

	@Test(priority=1, description = "Varify User can't logged with ")
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.login("Mahin","1234");
	}
}