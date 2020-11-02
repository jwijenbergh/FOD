package Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Login {
	@Test
	public static void SuccessLogin(WebDriver driver, String url) {
		try {
		driver.get(url);
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys("1");
		driver.findElement(By.id("applybutton")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
		}
		catch(Exception e) {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
			    fileWriter.write(e.getMessage());
			    fileWriter.close();
			} catch (IOException ex) {
			    // Cxception handling
			}
		}
		finally {
			driver.close();
		}
	}
	@Test
	public static void LoginWithoutLogin(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("Password");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Please enter a correct username and password. Note that both fields are case-sensitive.')]"));
		}
		catch(Exception e) {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
			    fileWriter.write(e.getMessage());
			    fileWriter.close();
			} catch (IOException ex) {
			    // Cxception handling
			}
		}
		finally {
			driver.close();
		}
	}
	@Test
	public static void LoginWithoutData(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Please enter a correct username and password. Note that both fields are case-sensitive.')]"));
		}
		catch(Exception e) {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
			    fileWriter.write(e.getMessage());
			    fileWriter.close();
			} catch (IOException ex) {
			    // Cxception handling
			}
		}
		finally {
			driver.close();
		}
	}
	@Test
	public static void LoginWithoutPassword(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("admin");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Please enter a correct username and password. Note that both fields are case-sensitive.')]"));
		}
		catch(Exception e) {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
			    fileWriter.write(e.getMessage());
			    fileWriter.close();
			} catch (IOException ex) {
			    // Cxception handling
			}
		}
		finally {
			driver.close();
		}
	}
	@Test
	public static void LoginWithWrongData(WebDriver driver, String url) {
		try {
			driver.get(url);
			driver.findElement(By.id("id_username")).click();
			driver.findElement(By.id("id_username")).sendKeys("rdg");
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("rdg");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Please enter a correct username and password. Note that both fields are case-sensitive.')]"));
		}
		catch(Exception e) {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\log.txt")) {
			    fileWriter.write(e.getMessage());
			    fileWriter.close();
			} catch (IOException ex) {
			    // Cxception handling
			}
		}
		finally {
			driver.close();
		}
	}


	public static void main(String[] args) {
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		String url = "http://localhost:8083/altlogin"; 
		
		SuccessLogin(driver, url);
		
		LoginWithoutLogin(driver, url);
		
		LoginWithoutData(driver, url);
		
		LoginWithoutPassword(driver, url);
		
		LoginWithWrongData(driver, url);
		
		
		//closing the browser
		driver.close();
	
	}

}