package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.RegisterPage;



public class RegisterPageTest extends BaseDriver{
	
	RegisterPage registerPage;
	
	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
	}

	@Test
	public void loginTest() throws InterruptedException {
		registerPage = new RegisterPage();
		registerPage.register("Mahin","shoily@gmail","1234","1234");
	}
}
