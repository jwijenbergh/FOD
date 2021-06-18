package test.java.Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DashboardTest {

        static WebDriver driver;
     
        static String url;	
        
        static ConfigFileReader configFileReader= new ConfigFileReader();
	
	//TODO: test cases
	
      @BeforeClass
      static void testSetUp() {
    	  
  		//setting the driver executable
  		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		driver=new ChromeDriver(chromeOptions);
		
		
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		url = configFileReader.getApplicationUrl() + "/altlogin";;;
        }
	
      public static void main(String[] args) {

                testSetUp();
		
		//AddName(driver, url);
		//AddName();
		
                testSetDown();
      }

      @AfterClass
      static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
