package com.mohs10.getData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getdata
{
	@Test
         public void testResponsecode() {
        	 
        	Response resp= RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
        	int code=resp.getStatusCode();
            if(code==200){  
                System.out.println("right ");  
            }else{  
                System.out.println("wrong");  
            }  
        	System.out.println("Status code is "+code);
      // 	Assert.assertEquals(code,200);
         }
}
