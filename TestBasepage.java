package com.evs.TestBasePage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.evs.genericLayer.GenericMathod;

public class TestBasepage {
	protected GenericMathod gm=new GenericMathod();
	
	@BeforeMethod
	public void browserLaunch() {
	gm.lounchBrowse(); 
	gm.openUrl("http://localhost:8888");
	gm.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	gm.driver.manage().window().maximize();
	gm.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void close() {
		gm.close();
	}
}