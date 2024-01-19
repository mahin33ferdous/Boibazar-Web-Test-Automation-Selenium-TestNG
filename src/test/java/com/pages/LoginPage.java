package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseDrivers.PageDriver;
import com.utilities.GetScreenShot;

public class LoginPage {

	
	ExtentTest test;
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
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
	
	@FindBy(xpath = "//p[@id=\"userPassCheck\"]") 
    WebElement logInErrorText; 
	
	@FindBy(xpath = "//button[contains(text(),'CREATE NEW ACCOUNT')]") 
    WebElement accButton;  
	
	//String error=logInErrorText.getText();
	
	
	

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
	
	@SuppressWarnings("unused")
	public void failCasewithOutput(String message, String scName, String outpuut) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+" "+outpuut+"</b></p>");
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
	public void loginWithInvalidPassword(String n,String p) throws InterruptedException, IOException {
//
//		signIn.click();
//		Thread.sleep(1000);
//		name.sendKeys(n);
//		Thread.sleep(1000);
//		password.sendKeys(p);
//		Thread.sleep(3000);
//		logInButton.click();
//		Thread.sleep(3000);
			
		

	// Verify Sign in button action.........................................
		try {
			test.info("Verify sign in button is visible");
			  if(signIn.isDisplayed())
			  {
				signIn.click();
				Thread.sleep(1000);
				passCase("sign in option clicked");
				
			  }
	// Verify email input action ......................................................
			   try {
				  test.info("Verify username input field is visible");
				  if(name.isDisplayed())
				  {
				    name.sendKeys(n);
					Thread.sleep(3000);
					passCase("username input field is visible and filled successfully");
				  }
				  
				// verify password input action	...........................................................
				  try {
					  test.info("Verify password input field is visible");
					  if(password.isDisplayed())
					  {
					     password.sendKeys(p);
						 Thread.sleep(3000);
						passCase("password input field is visible and filled successfully");
					  }
					  
					// verify login with correct username and password action	...................................................	
					  try {
						  test.info("Verify sign in button is visible ");
						  if(logInButton.isDisplayed())
						  {
							logInButton.click();
							Thread.sleep(3000);
							passCase("sign in button is visible and user successfully clicked in");
						  }  
						// verify login with correct username and password action	...................................................	
						  try {
							  test.info("Verify sign in button is clicked and user signed in ");
							  
							  
							  String Error_text_not_shown_signin = logInErrorText.getText();
							  System.out.println(Error_text_not_shown_signin);
							 
							  if(Error_text_not_shown_signin.isEmpty())
							  {
								
								passCase("sign in is completed and user successfully signed in");
							  } 
							  else {
								  failCasewithOutput("sign in is incomplete and error text is shown. Please check the error message :", "signinfail", Error_text_not_shown_signin );
							  }
					  }
						  
						  catch(Exception e){
							  failCase("sign in is incomplete and error text is shown. Please check the error message", "signinfail");
						  } 
				  }
					  catch(Exception e){
						  failCase("sign in button is not clickable. Please check the error message", "loginButtonfail");
					  }  
				
				 
				  }
					  catch(Exception e){
						  failCase("password input field was not locateable. Please check the error message", "passwordInputEntryfail");
					  }  
					  
				 }
			   catch(Exception e){
					  failCase("username input field was not locateable. Please check the error message", "usernameInputEntryfail");
				  }
				}
	   
		   catch(Exception e){
				failCase("sign in option was not locateable. Please check the error message", "signinOptionfail");
			}
	}
	
	

}