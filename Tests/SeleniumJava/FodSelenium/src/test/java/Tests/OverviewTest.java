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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.base.Preconditions;

public class OverviewTest {

        static WebDriver driver;
     
        static String url;	
        
        static ConfigFileReader configFileReader= new ConfigFileReader();
	
	//TODO: test cases
        public static void Login() 
        {
        	try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
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
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
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
    	static void GoToSideDashboardFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideDashboardFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
    	static void GoToSideRulesFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideRulesFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
    	static void GoToSideAddRuleFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAddRuleFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
    	static void GoToSideOverviewFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideOverviewFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
    	static void GoToSideAdminFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAdminFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
    	static void GoToSideMyProfileFromOverview() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideMyProfileFromOverview");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
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
        					buffer.append("Find edit my profile header: my_profile_header_id");
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
    	static void UserButtonFromOverviewTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("UserButtonFromOverviewTable");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("overview_users_button")).click();
        					buffer.append("Find and click on users button: overview_users_button");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("overview_user_table_username_header"));
        					buffer.append("Find user table name: overview_user_table_username_header");
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
    	static void RulesButtonFromOverviewTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("RulesButtonFromOverviewTable");
        		buffer.newLine();
        				try {
        					driver.findElement(By.id("navigation_overview_id")).click();
        					buffer.append("Find and click on overview button: navigation_overview_id");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("overview_rules_button")).click();
        					buffer.append("Find and click on rules button: overview_rules_button");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("overview_rules_table_name_header"));
        					buffer.append("Find rules table name: overview_rules_table_name_header");
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
    	static void RoutesTableLength5() {
    		for(int i = 0; i < 5; i++)
    			AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("RoutesTableLength5");
        		buffer.newLine();
        				
        				try {
        					Select drpRoutes = new Select(driver.findElement(By.name("routes_table_length")));
        					drpRoutes.selectByVisibleText("5");
        					buffer.append("Find and select on records per page button: routes_table_length");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement (By.xpath ("//*[contains(text(),'Showing 1 to 5 of')]"));
        					buffer.append("Find and text: Showing 1 to 5 of");
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
    	static void RoutesTableLength15() {
    		for(int i = 0; i < 15; i++)
    			AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("RoutesTableLength15");
        		buffer.newLine();
        				
        				try {
        					Select drpRoutes = new Select(driver.findElement(By.name("routes_table_length")));
        					drpRoutes.selectByVisibleText("15");
        					buffer.append("Find and select on records per page button: routes_table_length");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement (By.xpath ("//*[contains(text(),'Showing 1 to 15 of')]"));
        					buffer.append("Find and text: Showing 1 to 15 of");
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
    	static void RoutesTableLength20() {
    		for(int i = 0; i < 20; i++)
    			AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\OverviewReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("RoutesTableLength20");
        		buffer.newLine();
        				
        				try {
        					Select drpRoutes = new Select(driver.findElement(By.name("routes_table_length")));
        					drpRoutes.selectByVisibleText("20");
        					buffer.append("Find and select on records per page button: routes_table_length");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement (By.xpath ("//*[contains(text(),'Showing 1 to 20 of')]"));
        					buffer.append("Find and text: Showing 1 to 20 of");
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
		
                GoToSideDashboardFromOverview();
                GoToSideRulesFromOverview();
                GoToSideAddRuleFromOverview();
                GoToSideOverviewFromOverview();
                GoToSideAdminFromOverview();
                GoToSideMyProfileFromOverview();
                UserButtonFromOverviewTable();
                RulesButtonFromOverviewTable();
		
                testSetDown();
      }

      @AfterClass
      static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
