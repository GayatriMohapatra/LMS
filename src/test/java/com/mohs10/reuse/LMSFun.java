package com.mohs10.reuse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.mohs10.base.StartBrowser;
import com.github.dockerjava.api.model.Driver;
import com.mohs10.ActionDriver.Action;

import com.mohs10.or.LMSPage;

public class LMSFun<Select> extends Action {

	public static Action aDriver;
	public WebDriver driver;

	public LMSFun() {
		aDriver = new Action();
		driver = StartBrowser.driver;
	}
	
	
	public void login(String url, String username, String password) throws Exception {

		 

        StartBrowser.childTest = StartBrowser.parentTest.createNode("login");
        aDriver.navigateToApplication(url);
        aDriver.type(LMSPage.username, username, "type username");
        aDriver.type(LMSPage.Password, password, "type password");
        aDriver.click(LMSPage.Loginbtn, "click on login btn");
        Thread.sleep(5000);

/*	public void login(String url,String emailid,String pswd, String number) throws Exception {

		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Manager Page");
		
		aDriver.navigateToApplication(url);
		
		
		aDriver.type(LMSPage.emailid,emailid,"Enter the mailid");
		aDriver.type(LMSPage.pswd,pswd,"enter the password");
		Thread.sleep(3000);
		
		aDriver.click(LMSPage.loginbtn,"click on Login");
		aDriver.click(LMSPage.dshbrd, "Click on dashboard");
		Thread.sleep(5000);
		
		aDriver.click(LMSPage.lvpolicy, "Click on policy");
		driver.navigate().back();
		aDriver.click(LMSPage.leaveplicy, "click back to leave policy");
		Thread.sleep(3000);
		
		aDriver.click(LMSPage.calendar, "Click on calendar");
		driver.navigate().back();
		aDriver.click(LMSPage.leaveplicy, "click back to leave policy");
		aDriver.click(LMSPage.empcalendar,"click on emp calendar");
		aDriver.selectDropDown(LMSPage.typeleave, "value", "PL");
		aDriver.type(LMSPage.number,number,"enter the no.");
		*/
		//aDriver.selectDropDown(LMSPage.date, "index", "22-06-2023");
		  Thread.sleep(5000);
		
		
		
		
	}

		















}


