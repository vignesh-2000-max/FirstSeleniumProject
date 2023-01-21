package com.v2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase{

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	
    //public static WebDriverManager manager;
   @BeforeSuite
	public void setUp()   {

		if(driver==null) {
		    try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				config.load(fis);
				log.debug("Config file loader !!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         try {
				OR.load(fis);
				log.debug("OR file loader !!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	         if(config.getProperty("browser").equals("chrome")) {
	        	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\chromedriver.exe");
	        	// WebDriverManager.chromedriver().setup();
	        	 driver=new ChromeDriver();
	        	 log.debug("Chrome launched !!");
	         }
	         
	         driver.get(config.getProperty("testurl"));
	         //driver.get("http://gmail.com");
	         log.debug("nvigated to : "+config.getProperty("testurl"));
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         wait =new WebDriverWait(driver,10);
		}
	}
   
   public static boolean isElementPresent(By by) {
	   
	   try {
		   driver.findElement(by);
		   return true;
	   }catch(NoSuchElementException e) {
		   return false;
	   }
   }
    
    @AfterSuite
	public void tearDown() {
      if(driver!=null) {
    	  driver.quit();
    	  
      }
      log.debug("test execution completed !!");
	}
}
