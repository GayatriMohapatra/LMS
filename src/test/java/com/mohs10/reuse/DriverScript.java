package com.mohs10.reuse;

/*ctrl+shift+o :--- to add necessary imports and remove unused imports*/
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mohs10.ActionDriver.ExcelUtils;
import com.mohs10.ActionDriver.FunctionalLibrary;
import com.mohs10.base.StartBrowser;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverScript extends StartBrowser 
{
	String inputFile = "C:\\Users\\Tharun\\Downloads\\Demo-Painite-master\\Demo-Painite-master\\TestInput\\TestData.xlsx"; 
	String outputFile = "C:\\Users\\Tharun\\Downloads\\Demo-Painite-master\\Demo-Painite-master\\TestOutPut\\HybridReports.xlsx";
	
	com.relevantcodes.extentreports.ExtentReports reports;
	ExtentTest test;
	
	//Executable Method
	public void startTest() throws Throwable  
	{
		//create object for excel file util class
		ExcelUtils xl = new ExcelUtils(inputFile);
		
		//iterate all rows in master test cases sheet
		for(int i = 1; i<=xl.rowCount("MasterTestCases");i++)
		{
			String ModuleStatus = "";
			if(xl.getCellData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
			{
				//store corresponding test case into variable TCModule
				String TCModule =xl.getCellData("MasterTestCases", i, 1); // All Test cases are stored in TCModule, which is a MasterTestCases sheet
				
				//code for generate extent reports
				reports = new com.relevantcodes.extentreports.ExtentReports("./AutomationReports/"+TCModule+".html"+"_"+FunctionalLibrary.generateDate());
				test = reports.startTest(TCModule);
				
				//corresponding should be iterated
				for(int j=2; j<=xl.rowCount(TCModule);j++){
					String Description = xl.getCellData(TCModule, j, 0);
					String Method_Keywords = xl.getCellData(TCModule, j, 1);
					String Locator_Name = xl.getCellData(TCModule, j, 2);
					String Locator_Value = xl.getCellData(TCModule, j, 3);
					String TestData = xl.getCellData(TCModule, j, 4);
					
					try {
						
						 if(Method_Keywords.equalsIgnoreCase("openUrl"))	{
							FunctionalLibrary.openUrl(driver, TestData);
							test.log(LogStatus.INFO, Description);	}
						else if(Method_Keywords.equalsIgnoreCase("clickAction"))	{
							FunctionalLibrary.clickAction(driver, Locator_Name, Locator_Value);
							test.log(LogStatus.INFO, Description);	}
						else if(Method_Keywords.equalsIgnoreCase("typeAction"))	{
							FunctionalLibrary.typeAction(driver, Locator_Name, Locator_Value, TestData);
							test.log(LogStatus.INFO, Description);	}
						else if(Method_Keywords.equalsIgnoreCase("waitForElement"))	{
							//FunctionalLibrary.waitForElement(driver, Locator_Name, Locator_Value, TestData);
							test.log(LogStatus.INFO, Description);	}
					    else if(Method_Keywords.equalsIgnoreCase("captureData"))	{
							FunctionalLibrary.captureData(driver, Locator_Name, Locator_Value);
							test.log(LogStatus.INFO, Description);	}
			//write as Pass in Status cell - This is ApplicationLogin sheet 
						xl.setCellData(TCModule, j, 5, "Pass", outputFile);
						test.log(LogStatus.PASS, Description);
						File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
						FileUtils.copyFile(srcFile, new File("./screenShots/"+Description+".png"));
						String image = test.addScreenCapture("./screenShots/"+Description+".png");
						ModuleStatus = "True";
						}
					
					catch (Exception e)	{
						System.out.println(e.getMessage()); 
						
						xl.setCellData(TCModule, j, 5, "Fail", outputFile);
						test.log(LogStatus.FAIL, Description);
						ModuleStatus = "False";
						
						//capturing screenshot for failed test cases and storing in srcFile
						File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
						FileUtils.copyFile(srcFile, new File("./failedScreenShots/"+Description+".png"));
						String image = test.addScreenCapture("./failedScreenShots/"+Description+".png");
						test.log(LogStatus.FAIL, image);
						break;	}
					
					//The below stmt is for MasterTestCase Sheet - Here When all test steps get pass, it will update pass other wise fail
					if(ModuleStatus.equalsIgnoreCase("True"))	{
						xl.setCellData("MasterTestCases", i, 3, "Pass", outputFile);	}
					else	{
						xl.setCellData("MasterTestCases", i, 3, "Fail", outputFile);
							}}}
			
			else	{
				xl.setCellData("MasterTestCases", i, 3, "Blocked", outputFile); 
			}
			reports.endTest(test);
			reports.flush();
			}}}
