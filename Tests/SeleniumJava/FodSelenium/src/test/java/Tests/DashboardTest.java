package test.java.Tests;

import java.io.FileWriter;
import java.io.BufferedWriter;
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
        public static void Login() 
        {
        	try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
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
        
    	public static void AddRule() 
            {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AddRule");
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
        					driver.findElement(By.id("id_name")).sendKeys(configFileReader.getRuleName());
        					buffer.append("Put into name input: " + configFileReader.getRuleName());
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
    	static void AppearedRuleOnDashboard() {
    		AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.getPageSource().contains(configFileReader.getRuleName()))
        					{
        						buffer.append("Find on dashboard button rule: " + configFileReader.getRuleName());
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find on dashboard button rule: " + configFileReader.getRuleName());
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
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
    	static void FixItButtonOnDashboard() {
    		AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("edit_button_1")).click();
        					buffer.append("Find and click on fix it button: edit_button_1");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("apply_rule_header_id"));
        					buffer.append("Find edir rule header: apply_rule_header_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
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
    	static void GoToAddRuleFromDashboard() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("routebutton")).click();
        					buffer.append("Find and click on add rule button: routebutton");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("apply_rule_header_id"));
        					buffer.append("Find edir rule header: apply_rule_header_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
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
    	static void GoToMyRulesFromDashboard() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("myrulesbutton")).click();
        					buffer.append("Find and click on my rules button: myrulesbutton");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("myrulesheader"));
        					buffer.append("Find edir rule header: myrulesheader");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
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
    	static void GoToMyProfileFromDashboard() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("myprofilebutton")).click();
        					buffer.append("Find and click on my profile button: myprofilebutton");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("my_profile_header_id"));
        					buffer.append("Find edir my profile header: my_profile_header_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
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
