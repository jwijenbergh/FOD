package test.java.Tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.google.common.base.Preconditions;

public class LogoutTest {

        static String url; 
   
        static WebDriver driver;
        
        static ConfigFileReader configFileReader = new ConfigFileReader();

	@Test
	//public static void SuccessLogout(WebDriver driver, String url) {
	public static void SuccessLogout() {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\LogOut.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter); 
			buffer.newLine();
			buffer.append("SuccessLogout");
			buffer.newLine();
			try {
				driver.get(url);
				buffer.append("Go to url: "+ url );
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage() );
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("id_username")).click();
				buffer.append("Find login input: id_username ");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("id_username")).sendKeys(configFileReader.getUserLogin());
				buffer.append("Add in login input data: " + configFileReader.getUserLogin());
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("id_password")).click();
				buffer.append("Find password input: id_password");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("id_password")).sendKeys(configFileReader.getUserPassword());
				buffer.append("Add in password input data: " + configFileReader.getUserPassword());
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("applybutton")).click();
				buffer.append("Find and click on Apply button: applybutton");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			
			try {
				driver.findElement(By.id("myrulesheader"));
				buffer.append("Find and My rules header: myrulesheader");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			try {
				driver.findElement(By.id("user_icon_id")).click();
				buffer.append("Find and click on User icon: user_icon_id");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			try {
				driver.findElement(By.id("log_out_id")).click();
				buffer.append("Find and click on LogOut button: log_out_id");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
			try {
				driver.getTitle().contains("Example Domain");
				buffer.append("Find first page title: Example Domain");
				buffer.newLine();
			}catch(IOException exc) {
				buffer.append(exc.getMessage());
				buffer.newLine();
			}
		 buffer.close(); 
        }
	catch(Exception e) {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
		    fileWriter.write(e.getMessage());
		    fileWriter.close();
		} catch (IOException ex) {
		    // Cxception handling
		}
		         
	}
	}
	
        @BeforeClass
	static public void testSetUp() {
        
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
