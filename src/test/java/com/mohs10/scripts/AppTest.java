package com.mohs10.scripts;

import org.testng.annotations.Test;

import com.mohs10.base.StartBrowser;
import com.mohs10.reuse.DriverScript;

public class AppTest extends StartBrowser
{
	@Test
	public void kickStart() throws Throwable
	{
		DriverScript ds = new DriverScript();
		ds.startTest();
	}
}
