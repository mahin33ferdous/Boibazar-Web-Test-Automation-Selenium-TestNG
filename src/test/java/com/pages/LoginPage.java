package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.baseDrivers.PageDriver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	
	@FindBy(xpath = "//a[@class=\"loginHeader\"  and contains(text(),\"Sign In\")]") 
    WebElement signIn; 
	
	@FindBys({
			
			@FindBy(xpath = "//input[@id=\"signInName\"]") })
	WebElement name;
	
	@FindBy(xpath = "//input[@id=\"signInPassword\"]") 
       WebElement password;  
	
	@FindBy(xpath = "//button[@id=\"signin\"]") 
    WebElement logInButton;  
	




	public void login(String n,String p) throws InterruptedException {

		signIn.click();
		Thread.sleep(1000);
		name.sendKeys(n);
		Thread.sleep(1000);
		password.sendKeys(p);
		Thread.sleep(3000);
		logInButton.click();
		Thread.sleep(3000);
	}

}