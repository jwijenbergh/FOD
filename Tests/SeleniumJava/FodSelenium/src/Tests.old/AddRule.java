package Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



public class AddRule {

	@Test
	public static void AddName(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			driver.findElement(By.id("applybutton")).click();
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
	
	@Test
	public static void AddWrongName(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("1' or '1' = '1 /*");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Enter a valid \'slug\' consisting of letters, numbers, underscores or hyphens.')]"));
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
	
	@Test
	public static void AddWrongSourceAddress(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("efefef");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Invalid network address format')]"));
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
	
	@Test
	public static void AddWrongDestinationAddress(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("drgr");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Invalid network address format')]"));
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
	
	@Test
	public static void AddWithOutExpires(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_expires")).click();
			driver.findElement(By.id("id_expires")).clear();
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'This field is required.')]"));
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
	
	@Test
	public static void AddWrongSrcPort(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_sourceport")).click();
			driver.findElement(By.id("id_sourceport")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
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
	
	@Test
	public static void AddWrongDestPort(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_destinationport")).click();
			driver.findElement(By.id("id_destinationport")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
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
	
	@Test
	public static void AddWrongPort(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("1");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Apply for a new rule')]"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_port")).click();
			driver.findElement(By.id("id_port")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
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
	
	public static void main(String[] args) {
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver(chromeOptions);
		
		
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		String url = "http://localhost:8083/altlogin"; 
		
		AddName(driver, url);
		AddWrongName(driver, url);
		AddWrongSourceAddress(driver, url);
		AddWrongDestinationAddress(driver, url);
		AddWithOutExpires(driver, url);
		AddWrongSrcPort(driver, url);
		AddWrongDestPort(driver, url);
		AddWrongPort(driver, url);
		
		
		//closing the browser
		driver.close();
	
	}
}
