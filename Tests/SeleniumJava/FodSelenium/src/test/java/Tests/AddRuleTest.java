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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class AddRuleTest {
 
        static WebDriver driver;

        static String url;
        
        static ConfigFileReader configFileReader = new ConfigFileReader();
        
        public static void Login() 
        {
        	try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("Login");
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
	//public static void AddName(WebDriver driver, String url) 
	public static void AddName() 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
    		BufferedWriter buffer = new BufferedWriter(fileWriter);  
    		buffer.newLine();
    		buffer.append("Login");
    		buffer.newLine();
    				try {
    					driver.findElement(By.id("routebutton")).click();
    					buffer.append("Find and click on add route button: routebutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage() );
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("apply_rule_header_id"));
    					buffer.append("Find add rule header: apply_rule_header_id ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).click();
    					buffer.append("Find and click Name input: id_name");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).sendKeys("npattack");
    					buffer.append("Put into name input: npattack");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).click();
    					buffer.append("Find input: id_source");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
    					buffer.append("Put into source: 0.0.0.0/0");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_destination")).click();
    					buffer.append("Find Destination input: id_destination");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
    					buffer.append("Put into Destination input: 0.0.0.0/29");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("applybutton")).click();
    					buffer.append("Find and click Apply button: applybutton");
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
	public static void AddWrongName() 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
    		BufferedWriter buffer = new BufferedWriter(fileWriter);  
    		buffer.newLine();
    		buffer.append("Login");
    		buffer.newLine();
    				try {
    					driver.findElement(By.id("routebutton")).click();
    					buffer.append("Find and click on add route button: routebutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage() );
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("apply_rule_header_id"));
    					buffer.append("Find add rule header: apply_rule_header_id ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).click();
    					buffer.append("Find and click Name input: id_name");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).sendKeys("1' or '1' = '1 /*");
    					buffer.append("Put into name input: 1' or '1' = '1 /*");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).click();
    					buffer.append("Find input: id_source");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
    					buffer.append("Put into source: 0.0.0.0/0");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_destination")).click();
    					buffer.append("Find Destination input: id_destination");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
    					buffer.append("Put into Destination input: 0.0.0.0/29");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("applybutton")).click();
    					buffer.append("Find and click Apply button: applybutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("name_error_id"));
    					buffer.append("Find text error: name_error_id");
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
	//public static void AddWrongName(WebDriver driver, String url) 
	public static void AddNoName() 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
    		BufferedWriter buffer = new BufferedWriter(fileWriter);  
    		buffer.newLine();
    		buffer.append("Login");
    		buffer.newLine();
    				try {
    					driver.findElement(By.id("routebutton")).click();
    					buffer.append("Find and click on add route button: routebutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage() );
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("apply_rule_header_id"));
    					buffer.append("Find add rule header: apply_rule_header_id ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).click();
    					buffer.append("Find and click Name input: id_name");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).sendKeys("");
    					buffer.append("Put nothing into name input: ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("applybutton")).click();
    					buffer.append("Find and click Apply button: applybutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					WebElement inputName = driver.findElement(By.id("id_name"));
    					JavascriptExecutor js = (JavascriptExecutor) driver;  
    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
    					if(isRequired )
    					{
    						buffer.append("Find required attribute: id_name");
    						buffer.newLine();
    					}else {
    						buffer.append("!!!!!!!!!!");
    						buffer.append("FAILED: Find required attribute: id_name");
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
	//public static void AddWrongSourceAddress(WebDriver driver, String url) 
	public static void AddWrongSourceAddress() 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
    		BufferedWriter buffer = new BufferedWriter(fileWriter);  
    		buffer.newLine();
    		buffer.append("Login");
    		buffer.newLine();
    				try {
    					driver.findElement(By.id("routebutton")).click();
    					buffer.append("Find and click on add route button: routebutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage() );
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("apply_rule_header_id"));
    					buffer.append("Find add rule header: apply_rule_header_id ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).click();
    					buffer.append("Find and click Name input: id_name");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).sendKeys("npattack");
    					buffer.append("Put into name input: npattack");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).click();
    					buffer.append("Find input: id_source");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).sendKeys("efefef");
    					buffer.append("Put into source wrong data: efefef");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_destination")).click();
    					buffer.append("Find Destination input: id_destination");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
    					buffer.append("Put into Destination input: 0.0.0.0/29");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("applybutton")).click();
    					buffer.append("Find and click Apply button: applybutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("source_error_id"));
    					buffer.append("Find text error: source_error_id");
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
	//public static void AddWrongDestinationAddress(WebDriver driver, String url) 
	public static void AddWrongDestinationAddress() 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\AddRulesReport.txt", true)) {
    		BufferedWriter buffer = new BufferedWriter(fileWriter);  
    		buffer.newLine();
    		buffer.append("Login");
    		buffer.newLine();
    				try {
    					driver.findElement(By.id("routebutton")).click();
    					buffer.append("Find and click on add route button: routebutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage() );
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("apply_rule_header_id"));
    					buffer.append("Find add rule header: apply_rule_header_id ");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).click();
    					buffer.append("Find and click Name input: id_name");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_name")).sendKeys("npattack");
    					buffer.append("Put into name input: npattack");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).click();
    					buffer.append("Find input: id_source");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
    					buffer.append("Put into source: 0.0.0.0/0");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				
    				try {
    					driver.findElement(By.id("id_destination")).click();
    					buffer.append("Find Destination input: id_destination");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("id_destination")).sendKeys("fdfd");
    					buffer.append("Put into Destination input wrong data: fdfd");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("applybutton")).click();
    					buffer.append("Find and click Apply button: applybutton");
    					buffer.newLine();
    				}catch(IOException exc) {
    					buffer.append(exc.getMessage());
    					buffer.newLine();
    				}
    				try {
    					driver.findElement(By.id("destination_error_id"));
    					buffer.append("Find text error: destination_error_id");
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
	//public static void AddWithOutExpires(WebDriver driver, String url) 
	public static void AddWithOutExpires() 
        {
		try {
			Login();
			driver.findElement(By.id("myrulesheader"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.id("apply_rule_header_id"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_expires")).click();
			driver.findElement(By.id("id_expires")).clear();
			driver.findElement(By.id("applybutton")).click();
			WebElement inputExpires = driver.findElement(By.id("id_expires"));
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputExpires);
			if(isRequired )
			{
				//buffer.append("Find required attribute: id_username");
				//buffer.newLine();
			}else {
				//buffer.append("!!!!!!!!!!");
				//buffer.append("FAILED: Find required attribute: id_username");
				//buffer.newLine();
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
	//public static void AddWrongSrcPort(WebDriver driver, String url) 
	public static void AddWrongSrcPort() 
        {
		try {
			Login();
			driver.findElement(By.id("myrulesheader"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.id("apply_rule_header_id"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_sourceport")).click();
			driver.findElement(By.id("id_sourceport")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.id("sourceport_error_id"));
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
	//public static void AddWrongDestPort(WebDriver driver, String url) 
	public static void AddWrongDestPort() 
        {
		try {
			Login();
			driver.findElement(By.id("myrulesheader"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.id("apply_rule_header_id"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_destinationport")).click();
			driver.findElement(By.id("id_destinationport")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.id("destinationport_error_id"));
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
	//public static void AddWrongPort(WebDriver driver, String url) 
	public static void AddWrongPort() 
        {
		try {
			Login();
			driver.findElement(By.id("myrulesheader"));
			driver.findElement(By.id("routebutton")).click();
			driver.findElement(By.id("apply_rule_header_id"));
			driver.findElement(By.id("id_name")).click();
			driver.findElement(By.id("id_name")).sendKeys("npattack");
			driver.findElement(By.id("id_source")).click();
			driver.findElement(By.id("id_source")).sendKeys("0.0.0.0/0");
			driver.findElement(By.id("id_destination")).click();
			driver.findElement(By.id("id_destination")).sendKeys("0.0.0.0/29");
			
			driver.findElement(By.id("id_port")).click();
			driver.findElement(By.id("id_port")).sendKeys("f//");
			driver.findElement(By.id("applybutton")).click();
			driver.findElement(By.id("port_error_id"));
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
    		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//Initiating your chromedriver
		driver=new ChromeDriver(chromeOptions);
		
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		url = configFileReader.getApplicationUrl() + "/altlogin";;
        }

	
        public static void main(String[] args) {
 
                testSetUp();
		

		AddName();


		AddWrongName();


		AddWrongSourceAddress();


		AddWrongDestinationAddress();


		AddWithOutExpires();


		AddWrongSrcPort();


		AddWrongDestPort();


		AddWrongPort();


                testSetDown();
          }
		
        @AfterClass 
        static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
