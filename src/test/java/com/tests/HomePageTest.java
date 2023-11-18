
package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.HomePage;


public class HomePageTest extends BaseDriver{

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
	}

	@Test
	public void SelectCategoryTest() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.selectCategory();
	}
}