/*package com.mohs10.database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Mercury_Info {
	public WebDriver driver;
	@Test
    public void testDB () throws ClassNotFoundException, SQLException, Exception	
{		
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
	   Class.forName("com.mysql.jdbc.Driver");
	
	System.out.println("Driver loaded");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mercuryinfo","root","Password");
	
	System.out.println("Connected to MySQL DB");
	
	Statement smt=con.createStatement();
	//executes sql statement
	ResultSet rs=smt.executeQuery("select * from mercuryinfo1");
	while(rs.next())
	{
	String Username=rs.getString("Username");
	System.out.println(":Database record is "+Username);
	
	String Password=rs.getString("Password");
	System.out.println(":Database record is "+Password);
	
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(Username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	Thread.sleep(3000);
	}
	con.close();
	System.out.println("prgrm is exited");
}
	 @BeforeClass
	  public void beforeClass() {
	   //instantiate chrome browser
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  @AfterClass
	  public void afterClass() {
	   //close chrome browser
	   driver.quit();
	  }

}*/
