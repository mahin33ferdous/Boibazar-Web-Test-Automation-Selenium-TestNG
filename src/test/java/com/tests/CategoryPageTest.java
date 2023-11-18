
package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.baseDrivers.BaseDriver;
import com.baseDrivers.PageDriver;
import com.pages.CategoryPage;
import com.pages.HomePage;



public class CategoryPageTest extends BaseDriver{

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
	}

	@Test(priority=1)
	public void AddToCart() throws InterruptedException {
		CategoryPage categoryPage = new CategoryPage();
		HomePage homePage = new HomePage();
		homePage.selectCategory();
		categoryPage.AddToCartButton();
		
	}
	

	@Test(priority=2)
	public void ViewCart() throws InterruptedException {
		CategoryPage categoryPage = new CategoryPage();
		categoryPage.ViewCart();
	}

}