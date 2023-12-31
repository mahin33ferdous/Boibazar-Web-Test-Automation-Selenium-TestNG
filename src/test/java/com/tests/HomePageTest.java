
package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.HomePage;
import com.utilities.ExtentFactory;


public class HomePageTest extends BaseDriver{
	
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(2000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Boibazar category selection</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");

	}

	@Test
	public void SelectCategoryTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>category selection</b></p>");
		HomePage homePage = new HomePage(childTest);
		homePage.selectCategory();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}