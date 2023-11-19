package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseDrivers.PageDriver;
import com.utilities.GetScreenShot;

public class HomePage {
	
	ExtentTest test;

	public HomePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({
			
			@FindBy(xpath = "//ul/li[2]/a[@class=\"dropdown-toggle\"]") })
	WebElement lekkhok;
	
	@FindBy(xpath = "//ul/li[1]/a[@class=\"dropdown-toggle\"]") 
       WebElement bishoy;  
	
	@FindBy(xpath = "//span[contains(text(),'সমকালীন উপন্যাস')]") 
    WebElement uponnash;  
	

	
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
	public void selectCategory() throws InterruptedException, IOException {
		
		try {
			test.info("verify lekkhok menu is visible");
			if (lekkhok.isDisplayed()) {
				lekkhok.click();
				Thread.sleep(3000);
				passCase("Lekkhok option clicked");

				try {
					test.info("verify bishoy menu is visible");
					if (bishoy.isDisplayed()) {
						bishoy.click();
						Thread.sleep(3000);
						passCase("bishoy option clicked");

						try {
							test.info("verify uponnash menu visibility");
							if (uponnash.isDisplayed()) {
								uponnash.click();
								Thread.sleep(3000);
								passCaseWithSC("successfully redirectd to uponnash page", "CategorySelectionPassed");
							}
						} catch (Exception e) {
							failCase("Uponnash option was not locateable. Please check the error message",
									"CategorySelectionfail");
						}

					}
				} catch (Exception e) {
					failCase("bishoy option was not locateable. Please check the error message", "bishoyOptionfail");
				}

			}
		} catch (Exception e) {
			failCase("lekkhok option was not locateable. Please check the error message", "lekkhokOptionfail");
		}

	}




}