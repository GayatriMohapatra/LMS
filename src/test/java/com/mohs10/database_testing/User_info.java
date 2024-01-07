/*package com.mohs10.database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

public class User_info {
	
		
	@Test
    public void testDB () throws ClassNotFoundException, SQLException	
{		
	Class.forName("com.mysql.jdbc.Driver");
	
	System.out.println("Driver loaded");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","password");
	
	System.out.println("Connected to MySQL DB");
	
	Statement smt=con.createStatement();
	ResultSet rs=smt.executeQuery("select * from userinfo1");
	while(rs.next())
	{
	String Email=rs.getString("Email");
	System.out.println(":Database record is "+Email);
	
	String Password=rs.getString("Password");
	System.out.println(":Database record is "+Password);

	}
}
}*/
