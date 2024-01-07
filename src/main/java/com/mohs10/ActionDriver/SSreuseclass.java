package com.mohs10.ActionDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;



public class SSreuseclass 
{
	 public static void SSReusablemethod(WebDriver driver, String SSName) //Parameterized to screenshotname
	    {
	        try {
	            TakesScreenshot ts = (TakesScreenshot)driver;
	            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(src, new File("./TestcaseScreenshots/"+SSName+".png")); //passing parameter, no override of images
	            
	            System.out.println("Screen captured and saved in TestcaseScreenshots folder");
	        }
	        catch (Exception e) {
	            System.out.println("Exception Occurred while taking Screenshot"+e.getMessage());
	            
	        }
	        
	    }
		

}


