package test.java.Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class SetupTest {

        static WebDriver driver;
    
        static String url;

	@Test
	//public static void OnlyPassword(WebDriver driver, String url) 
	public static void OnlyPassword() 
        {
		try {
			driver.get(url);
			driver.findElement(By.id("id_password")).click();
			driver.findElement(By.id("id_password")).sendKeys("adminpwd1");
			driver.findElement(By.id("applybutton")).click();
			//TODO: find how to check required fields
			String alertMessage = driver.switchTo().alert().getText();
	        if (alertMessage.equals("First name Should not contain Special Characters")) {
	            System.out.println("Error displayed: First name Should not contain Special Characters");
	            driver.switchTo().alert().dismiss();
	        } else {
	            System.out.println("Accepted");
	        }

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
	
	@Test
	//public static void OnlyNotSavePassword(WebDriver driver, String url) 
	public static void OnlyNotSavePassword() 
        {
			try {
				driver.get(url);
				driver.findElement(By.id("id_password")).click();
				driver.findElement(By.id("id_password")).sendKeys("adminpwd1");
				driver.findElement(By.id("applybutton")).click();
				//TODO: find how to check required fields
				String alertMessage = driver.switchTo().alert().getText();
		        if (alertMessage.equals("First name Should not contain Special Characters")) {
		            System.out.println("Error displayed: First name Should not contain Special Characters");
		            driver.switchTo().alert().dismiss();
		        } else {
		            System.out.println("Accepted");
		        }

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
		
		@Test
		//public static void OnlyRouterHost(WebDriver driver, String url) 
		public static void OnlyRouterHost() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_device")).click();
					driver.findElement(By.id("id_netconf_device")).sendKeys("22");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyWrongRouterHost(WebDriver driver, String url) 
		public static void OnlyWrongRouterHost() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_device")).click();
					driver.findElement(By.id("id_netconf_device")).sendKeys("<>");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyRouterPort(WebDriver driver, String url) 
		public static void OnlyRouterPort() 
                {
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_port")).click();
					driver.findElement(By.id("id_netconf_port")).sendKeys("22");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyWrongRouterPort(WebDriver driver, String url) 
		public static void OnlyWrongRouterPort() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_port")).click();
					driver.findElement(By.id("id_netconf_port")).sendKeys("<>");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyRouterUser(WebDriver driver, String url) 
		public static void OnlyRouterUser() 
                {
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_user")).click();
					driver.findElement(By.id("id_netconf_user")).sendKeys("user");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyWrongRouterUser(WebDriver driver, String url) 
		public static void OnlyWrongRouterUser() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_user")).click();
					driver.findElement(By.id("id_netconf_user")).sendKeys("<>");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyRouterPassword(WebDriver driver, String url) 
		public static void OnlyRouterPassword() 
                {
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_pass")).click();
					driver.findElement(By.id("id_netconf_pass")).sendKeys("Gf1!grGR00");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyNotSaveRouterPassword(WebDriver driver, String url) 
		public static void OnlyNotSaveRouterPassword() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_netconf_pass")).click();
					driver.findElement(By.id("id_netconf_pass")).sendKeys("1");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyTestIP(WebDriver driver, String url) 
		public static void OnlyTestIP() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_test_peer_addr")).click();
					driver.findElement(By.id("id_test_peer_addr")).sendKeys("0.0.0.0/30");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void OnlyWrongTestIP(WebDriver driver, String url) 
		public static void OnlyWrongTestIP() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_test_peer_addr")).click();
					driver.findElement(By.id("id_test_peer_addr")).sendKeys("<>");
					driver.findElement(By.id("applybutton")).click();
					//TODO: find how to check required fields
					String alertMessage = driver.switchTo().alert().getText();
			        if (alertMessage.equals("First name Should not contain Special Characters")) {
			            System.out.println("Error displayed: First name Should not contain Special Characters");
			            driver.switchTo().alert().dismiss();
			        } else {
			            System.out.println("Accepted");
			        }

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
			
		@Test
		//public static void GoodData(WebDriver driver, String url) 
		public static void GoodData() 
		{
				try {
					driver.get(url);
					driver.findElement(By.id("id_password")).click();
					driver.findElement(By.id("id_password")).sendKeys("adminpwd1");
					driver.findElement(By.id("id_netconf_device")).click();
					driver.findElement(By.id("id_netconf_device")).sendKeys("1.0.0.0/8");
					driver.findElement(By.id("id_netconf_port")).click();
					driver.findElement(By.id("id_netconf_port")).sendKeys("29");
					driver.findElement(By.id("id_netconf_user")).click();
					driver.findElement(By.id("id_netconf_user")).sendKeys("user");
					driver.findElement(By.id("id_netconf_pass")).click();
					driver.findElement(By.id("id_netconf_pass")).sendKeys("Gf12!grGR00");
					driver.findElement(By.id("id_test_peer_addr")).click();
					driver.findElement(By.id("id_test_peer_addr")).sendKeys("1.0.0.0/8");
					driver.findElement(By.id("applybutton")).click();
					
					//TODO: find how to check if main page
					driver.findElement(By.xpath("//*[contains(text(), 'My rules')]"));
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
	static void testSetUp() {
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		driver=new ChromeDriver(chromeOptions);
		
		
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		url = "http://172.17.0.2:8000/altlogin";

	}

	public static void main(String[] args) {

                testSetUp();

		
		//OnlyPassword(driver, url);
		OnlyPassword();
	
			
		testSetDown();

	}
	
	@AfterClass	
	static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
