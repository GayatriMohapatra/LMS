/*package com.mohs10.reuse;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import com.moh10.base.Action;
import com.moh10.base.StartBrowser;
import com.mohs10.or.Autoit_OR;

public class Autoit_reuse 
{
	public Action aDriver;
	public WebDriver driver;
	
	public Autoit_reuse()
	{
		aDriver = new Action();
		driver = StartBrowser.driver;
	}
	
	public void uploadWordFile() throws Exception
	{
		try {
		
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Register in Opencart site");
		
		aDriver.navigateToApplication("https://www.ilovepdf.com/word_to_pdf");
		
		aDriver.click(Autoit_OR.selectwordfile, "Wordtopdf convert btn");
		
		Runtime.getRuntime().exec("Fileupload.exe");
		
		aDriver.click(Autoit_OR.Converttopdf, "Convert btn");
		
		Thread.sleep(3000);
		aDriver.click(Autoit_OR.downloadbtn, "Download the converted file");	
		 
		}
		catch (StaleElementReferenceException e) {
			
		}
		finally {
			Runtime.getRuntime().exec("Filedownload.exe");
		}
		  
		Thread.sleep(5000);
	}
}*/
