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
import com.google.common.base.Preconditions;

public class ProfileTest {

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
        
    	
    	@Test
    	static void GoToAddRuleFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToAddRuleFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
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
    	static void GoToMyRulesFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToMyRulesFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
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
    	static void GoToDashboardFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToDashboardFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("dashboardbutton")).click();
        					buffer.append("Find and click on my profile button: dashboardbutton");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("dashboard_header_id"));
        					buffer.append("Find edir dashboard header: dashboard_header_id");
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
    	static void GoToSideDashboardFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideDashboardFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_dashboard_id")).click();
        					buffer.append("Find and click on dashboard button: navigation_dashboard_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("dashboard_header_id"));
        					buffer.append("Find dashboard header: dashboard_header_id");
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
    	static void GoToSideRulesFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideRulesFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_rules_id")).click();
        					buffer.append("Find and click on rules button: navigation_rules_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("myrulesheader"));
        					buffer.append("Find rules header: myrulesheader");
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
    	static void GoToSideAddRuleFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAddRuleFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_add_rule_id")).click();
        					buffer.append("Find and click on add rule button: navigation_add_rule_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("apply_rule_header_id"));
        					buffer.append("Find rules header: apply_rule_header_id");
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
    	static void GoToSideOverviewFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideOverviewFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("overview_header_id"));
        					buffer.append("Find overview header: overview_header_id");
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
    	static void GoToSideAdminFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAdminFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_admin_id")).click();
        					buffer.append("Find and click on admin button: navigation_admin_id");
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
    	static void GoToSideMyProfileFromMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideMyProfileFromMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on profile button: navigation_user_profile_id");
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
    	
    	@Test
    	static void GenerateTokenMyProfile() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\DashboardReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GenerateTokenMyProfile");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_user_profile_id")).click();
        					buffer.append("Find and click on my profile button: navigation_user_profile_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("generate_token")).click();
        					buffer.append("Find and click on token button: generate_token");
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
		
                GoToAddRuleFromMyProfile();
                GoToMyRulesFromMyProfile();
                GoToDashboardFromMyProfile();
                GoToSideRulesFromMyProfile();
                GoToSideAddRuleFromMyProfile();
                GoToSideOverviewFromMyProfile();
                GoToSideAdminFromMyProfile();
                GoToSideMyProfileFromMyProfile();
		
                testSetDown();
      }

      @AfterClass
      static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
