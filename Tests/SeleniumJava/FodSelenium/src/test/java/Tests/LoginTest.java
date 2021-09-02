package test.java.Tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import dataProvider.ConfigFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class LoginTest {

        static String url;
  
        static WebDriver driver;
        
        static ConfigFileReader configFileReader = new ConfigFileReader();
        

	@Test
	//public static void SuccessLogin(WebDriver driver, String url) 
	public static void SuccessLogin()
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
		BufferedWriter buffer = new BufferedWriter(fileWriter);  
		buffer.newLine();
		buffer.append("SuccessLogin");
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
	@Test
	//public static void LoginWithoutLogin(WebDriver driver, String url) 
	public static void LoginWithoutLogin() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter); 
			buffer.newLine();
			buffer.append("LoginWithoutLogin");
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
			driver.findElement(By.id("id_username")).sendKeys("");
			buffer.append("Add in login input empty data: " );
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
			WebElement inputLogin = driver.findElement(By.id("id_username"));
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputLogin);
			if(isRequired )
			{
				buffer.append("Find required attribute: id_username");
				buffer.newLine();
			}else {
				buffer.append("!!!!!!!!!!");
				buffer.append("FAILED: Find required attribute: id_username");
				buffer.newLine();
			}
			
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
	
	@Test
	//public static void LoginWithoutLogin(WebDriver driver, String url) 
	public static void LoginWithSQLInjection() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("LoginWithSQLInjection");
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
						driver.findElement(By.id("id_username")).sendKeys("105 OR 1=1");
						buffer.append("Add in login input data: 105 OR 1=1" );
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
						driver.findElement(By.id("id_password")).sendKeys("105 OR 1=1");
						buffer.append("Add in password input data: 105 OR 1=1");
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
						driver.findElement(By.id("login_error_id"));
						buffer.append("Find error: login_error_id");
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
	@Test 
	public static void LoginWithoutData()
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("LoginWithoutData");
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
				driver.findElement(By.id("id_username")).sendKeys("");
				buffer.append("Add in login input empty data: " );
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
				driver.findElement(By.id("id_password")).sendKeys();
				buffer.append("Add in password input empty data: ");
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
				WebElement inputLogin = driver.findElement(By.id("id_username"));
				WebElement inputPassword = driver.findElement(By.id("id_password"));
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputLogin);
				boolean isRequiredPass = (Boolean) js.executeScript("return arguments[0].required;",inputPassword);
				if(isRequired ||  isRequiredPass)
				{
					buffer.append("Find required attribute: id_username and id_password");
					buffer.newLine();
				}else {
					buffer.append("!!!!!!!!!!");
					buffer.append("FAILED: Find required attribute: id_username and id_password");
					buffer.newLine();
				}
				
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
	@Test
	//public static void LoginWithoutPassword(WebDriver driver, String url) 
	public static void LoginWithoutPassword() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter); 
			buffer.newLine();
			buffer.append("LoginWithoutPassword");
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
			buffer.append("Add in login input data: id_username" + configFileReader.getUserLogin());
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
			driver.findElement(By.id("id_password")).sendKeys("");
			buffer.append("Add in password input empty data: " );
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
			WebElement inputLogin = driver.findElement(By.id("id_username"));
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputLogin);
			if(isRequired )
			{
				buffer.append("Find required attribute: id_password");
				buffer.newLine();
			}else {
				buffer.append("!!!!!!!!!!");
				buffer.append("FAILED: Find required attribute: id_password");
				buffer.newLine();
			}
			
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
	@Test
	//public static void LoginWithWrongData(WebDriver driver, String url) 
	public static void LoginWithWrongData() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\report.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("LoginWithWrongData");
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
						driver.findElement(By.id("id_username")).sendKeys("wrong");
						buffer.append("Add in login input data: wrong" );
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
						driver.findElement(By.id("id_password")).sendKeys("wrong");
						buffer.append("Add in password input data: wrong");
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
						driver.findElement(By.id("login_error_id"));
						buffer.append("Find error: login_error_id");
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
	public static void testSetUp() {
        	
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		
		// declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		driver=new ChromeDriver(chromeOptions);
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();

                url = configFileReader.getApplicationUrl() + "/altlogin";
         }
	
          public static void main(String[] args) {   
  
   				testSetUp();
   				
		SuccessLogin();
		

		LoginWithoutLogin();
		

		LoginWithoutData();
		

		LoginWithoutPassword();
		

		LoginWithWrongData();
		
		LoginWithSQLInjection();
			
        		
                testSetDown();

                
          }
		
        @AfterClass
        public static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}


}
