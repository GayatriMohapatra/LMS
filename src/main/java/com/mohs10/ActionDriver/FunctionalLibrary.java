package com.mohs10.ActionDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionalLibrary 
{
	public static WebDriver driver;
	public static String expectednumber;

	public static void openUrl(WebDriver driver, String TestData) throws Throwable  
	{
		driver.get(TestData);
	}


	//wait for Element Method
	/*
	 * public static void waitForElement(WebDriver driver,String Locator_Name,
	 * String Locator_Vlaue, String TestData) { WebDriverWait wait = new
	 * WebDriverWait(driver, Integer.parseInt(TestData));
	 * if(Locator_Name.equalsIgnoreCase("xpath")) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * Locator_Vlaue))); } else if (Locator_Name.equalsIgnoreCase("id")) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator_Vlaue)
	 * )); } else if(Locator_Name.equalsIgnoreCase("name")) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(
	 * Locator_Vlaue))); } else if(Locator_Name.equalsIgnoreCase("linktext")) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(
	 * Locator_Vlaue))); } }//end of method
	 * 
	 */
	//Method for Text box
	public static void typeAction(WebDriver driver, String Locator_Name, String Locator_Value, String TestData) 
	{
		if(Locator_Name.equalsIgnoreCase("xpath")) 
		{
			driver.findElement(By.xpath(Locator_Value)).clear();
			driver.findElement(By.xpath(Locator_Value)).sendKeys(TestData);
		}
		else if(Locator_Name.equalsIgnoreCase("id")) 
		{
			driver.findElement(By.id(Locator_Value)).clear();
			driver.findElement(By.id(Locator_Value)).sendKeys(TestData); 
		}
		else if(Locator_Name.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(Locator_Value)).clear();
			driver.findElement(By.name(Locator_Value)).sendKeys(TestData);
		}
		else if(Locator_Name.equalsIgnoreCase("linktext")) 
		{
			driver.findElement(By.linkText(Locator_Value)).clear();
			driver.findElement(By.linkText(Locator_Value)).sendKeys(TestData);
		}
	}//end of method


	//Method for Clicking on element
	public static void clickAction(WebDriver driver, String Locator_Name, String Locator_Value) 
	{
		if(Locator_Name.equalsIgnoreCase("xpath")) 
		{
			driver.findElement(By.xpath(Locator_Value)).click();
		}
		if(Locator_Name.equalsIgnoreCase("id")) 
		{
			driver.findElement(By.id(Locator_Value)).sendKeys(Keys.ENTER);
		}
		if(Locator_Name.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(Locator_Value)).click();
		}
		if(Locator_Name.equalsIgnoreCase("linktext")) 
		{
			driver.findElement(By.linkText(Locator_Value)).click();
		}
		
	}//end of method


	//Method to Validate Title
	public static void validateTitle(WebDriver driver, String ExpectedTitle)
	{
		String ActualTitle = driver.getTitle();
		try 
		{
			Assert.assertEquals(ActualTitle, ExpectedTitle, "Title is not matching");
		}
		catch (Throwable e) 
		{
			System.out.println(e.getMessage()); 
		}//end of catch
	}//end of method

	//Method to generate Dates - This is not in selenium, its a java code
	public static String generateDate() 
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MM_YYYY");
		return df.format(date); 
	}//end of method


	//Method to capture the data
	public static void captureData(WebDriver driver,String Locator_Name,String Locator_Value)
	{
		expectednumber = driver.findElement(By.name(Locator_Value)).getAttribute("value");
	}//end of method


	
}//end of class 





 