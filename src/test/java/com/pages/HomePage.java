package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.baseDrivers.PageDriver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBys({
			
			@FindBy(xpath = "//ul/li[2]/a[@class=\"dropdown-toggle\"]") })
	WebElement lekkhok;
	
	@FindBy(xpath = "//ul/li[1]/a[@class=\"dropdown-toggle\"]") 
       WebElement bishoy;  
	
	@FindBy(xpath = "//span[contains(text(),'সমকালীন উপন্যাস')]") 
    WebElement uponnash;  
	




	public void selectCategory() throws InterruptedException {

		lekkhok.click();
		Thread.sleep(10000);
		bishoy.click();
		Thread.sleep(3000);
		uponnash.click();
		Thread.sleep(3000);
	}

}