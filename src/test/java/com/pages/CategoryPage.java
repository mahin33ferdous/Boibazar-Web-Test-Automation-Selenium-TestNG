package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseDrivers.PageDriver;

public class CategoryPage {
	
	public CategoryPage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	
	@FindBy(xpath = "//a[@id='addbtn36']") 
    WebElement addButton1;
	
	@FindBy(xpath = "//a[@id='addbtn38']") 
    WebElement addButton2;  
	
	@FindBy(xpath = " //body/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]")
    WebElement cartIcon; 
	




	public void AddToCartButton() throws InterruptedException {
		
		addButton1.click();
		Thread.sleep(3000);
		addButton2.click();
		Thread.sleep(3000);
	}
	
	public void ViewCart() throws InterruptedException {

		cartIcon.click();
		Thread.sleep(3000);

	}
}



