
package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.CategoryPage;
import com.pages.HomePage;
import com.utilities.ExtentFactory;



public class CategoryPageTest extends BaseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Boibazar add to cart and view cart</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");

	}

	@Test(priority=1)
	public void AddToCart() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>AddToCart</b></p>");
		CategoryPage categoryPage = new CategoryPage(childTest);
		HomePage homePage = new HomePage(childTest);
		homePage.selectCategory();
		categoryPage.AddToCartButton();
		
	}
	

	@Test(priority=2)
	public void ViewCart() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>ViewCart</b></p>");
		CategoryPage categoryPage = new CategoryPage(childTest);
		categoryPage.ViewCart();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}