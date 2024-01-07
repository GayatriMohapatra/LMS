package com.mohs10.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StartBrowser {
	 public static WebDriver driver;
	 //set up report
	 public static ExtentReports extent;
	 public static ExtentTest parentTest;
	 public static ExtentTest childTest;
	 ExtentSparkReporter sparkReporter;
	 
	 @BeforeTest
	 public void generateReport()
	 {
		 sparkReporter = new ExtentSparkReporter("Report/AutomationReport.html");
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReporter);
	 }
	 
	 @BeforeMethod
	 public void methodName(Method method)
	 {
		parentTest = extent.createTest(method.getName()); 
	 }
	  @BeforeClass
	  public void beforeClass() {
		 WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		   options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//WebDriverManager.firefoxdriver().setup();
		 // WebDriverManager.edgedriver().setup();
		  driver = new ChromeDriver();
		  //driver= new FirefoxDriver();
		  //driver= new EdgeDriver();
		  driver.manage().timeouts();
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
		  extent.flush();
	  }

	}