package com.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseDrivers.PageDriver;
import com.utilities.GetScreenShot;

public class CategoryPage {
	
	ExtentTest test;
	
	public CategoryPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	
	@FindBy(xpath = "//a[@id='addbtn36']") 
    WebElement addButton1;
	
	@FindBy(xpath = "//a[@id='addbtn38']") 
    WebElement addButton2;  
	
	@FindBy(xpath = " //body/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]")
    WebElement cartIcon; 
	

	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	@SuppressWarnings("static-access")
	public void AddToCartButton() throws InterruptedException, IOException {
		
		try {
			test.info("verify Add to cart is visible");
			if (addButton1.isDisplayed()) {
				addButton1.click();
				Thread.sleep(3000);
				passCase("Add to cart button clicked");

				try {
					test.info("verify Add to cart button is visible");
					if (addButton2.isDisplayed()) {
						addButton2.click();
						Thread.sleep(3000);
						passCase("Add to cart button clicked");

					}
				} catch (Exception e) {
					failCase("Add to cart button was not locateable. Please check the error message", "AddToCartButton2fail");
				}

			}
		} catch (Exception e) {
			failCase("Add to cart button was not locateable. Please check the error message", "AddToCartButton1fail");
		}

	}




	
	@SuppressWarnings("static-access")
	public void ViewCart() throws InterruptedException, IOException {
		
		try {
			test.info("verify cart icon is visible");
			if (cartIcon.isDisplayed()) {
				cartIcon.click();
				Thread.sleep(3000);
				passCase("cart icon clicked");
				passCaseWithSC("cart icon clicked and successfully redirectd to uponnash page", "CatIconClickedPassed");

			}
		} catch (Exception e) {
			failCase("cart icon was not locateable. Please check the error message", "CatIconClickedfail");
		}

	}


}



