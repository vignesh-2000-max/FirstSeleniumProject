package com.v2a.utilities;

import com.aventstack.extentreports.ExtentReports;

//import com.aventstack.extentreports.ExtentReports;

public class Extentmanager {
	
	 private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			
			extent = new ExtentReports();
			
		}
		return extent;
	}

}
