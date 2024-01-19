package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.LoginPage;
import com.utilities.ExtentFactory;

public class LoginTest extends BaseDriver{
	
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	 

	

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Log in</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test(priority=1, description = "Varify User log in with invalid password ")
	public void loginTestWithInvalidPassword() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>User log in</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.loginWithInvalidPassword("Mahin","1234");
		
	}
	
	
	
	@AfterClass
	public void report() {
		report.flush();
	}
}