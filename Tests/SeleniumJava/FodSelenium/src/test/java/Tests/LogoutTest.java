package test.java.Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LogoutTest {

        static String url; 
   
        static WebDriver driver;
        
        static ConfigFileReader configFileReader;

	@Test
	//public static void SuccessLogout(WebDriver driver, String url) {
	public static void SuccessLogout() {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin2");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("adminpwd1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.className("user_icon_id")).click();
			driver.findElement(By.className("log_out_id")).click();
			
			driver.getTitle().contains("Example Domain");
			}
			catch(Exception e) {
				try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
				    fileWriter.write(e.getMessage());
				    fileWriter.close();
				} catch (IOException ex) {
				    // Cxception handling
				}
                                throw(e);
			}
	}
	
        @BeforeClass
	static public void testSetUp() {
        	configFileReader= new ConfigFileReader();
    		//setting the driver executable
    		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		//WebDriver driver=new ChromeDriver(chromeOptions);
		driver=new ChromeDriver(chromeOptions);
		
		
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
        
                url = configFileReader.getApplicationUrl() + "/altlogin";;;
        }
		
        @AfterClass
	static public void testSetDown() {
			
		//closing the browser
		driver.close();
	}

        public static void main(String[] args) {
          testSetUp();


          SuccessLogout();
        }       

}
