package com.mohs10.scripts;

import java.net.URL;

import org.testng.annotations.Test;


import com.mohs10.ActionDriver.XLUtils;

import com.mohs10.base.StartBrowser;

import com.mohs10.reuse.LMSFun;

public class LMSTest extends StartBrowser {

	String excelFilePath = "C:\\Users\\DELL\\eclipse-workspace\\LMS Manager\\TestData\\Data.xlsx";
	String excelsheet = "Login";

	@Test 
	public void LoginTestCase3() throws Exception {
	  
	 LMSFun lm = new LMSFun();
	  
	  
	  int rowcount = XLUtils.getRowCount(excelFilePath, excelsheet);
	  
	  for (int i = 1; i < rowcount; i++) 
		
	  {
	  
	  String url = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 0);
	  String Email = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 1);
	  String pwd = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 2);
	//  String privilegeleave = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 3);
	 // String number =  XLUtils.getStringCellData(excelFilePath, excelsheet, i, 4);
	 lm.login(url,Email,pwd);
	  Thread.sleep(5000);
	
	
	

	  
	  }
	  
	  } 
	}



