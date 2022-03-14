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

public class MyRulesTest {

        static WebDriver driver;
     
        static String url;	
        
        static ConfigFileReader configFileReader= new ConfigFileReader();
	
	//TODO: test cases
        public static void Login() 
        {
        	try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
    	
    	public static void AddRuleWithName(Sting name) 
        {
		Login();
		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
    					driver.findElement(By.id("id_name")).sendKeys(name);
    					buffer.append("Put into name input: " + name);
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
    	static void AppearedRuleInMyRulesTable() {
    		AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("AppearedRuleOnDashboard");
        		buffer.newLine();
        				try {
        					if(driver.getPageSource().contains(configFileReader.getRuleName()))
        					{
        						buffer.append("Find in my rules table rule: " + configFileReader.getRuleName());
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table rule: " + configFileReader.getRuleName());
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
    	static void FixItButtonOnMyRules() {
    		AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("FixItButtonOnMyRules");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("edit_button_")).click();
        					buffer.append("Find and click on fix it button: edit_button_");
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
    	static void GoToAddRuleFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToAddRuleFromMyRules");
        		buffer.newLine();
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
    	static void GoToMyProfileFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToMyProfileFromMyRules");
        		buffer.newLine();

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
    	
    	@Test
    	static void GoToSideDashboardFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideDashboardFromMyRules");
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
    	static void GoToSideRulesFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideRulesFromMyRules");
        		buffer.newLine();
        				
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
    	static void GoToSideAddRuleFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAddRuleFromMyRules");
        		buffer.newLine();
        				
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
    	static void GoToSideOverviewFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideOverviewFromMyRules");
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
    	static void GoToSideAdminFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideAdminFromMyRules");
        		buffer.newLine();

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
    	static void GoToSideMyProfileFromMyRules() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("GoToSideMyProfileFromMyRules");
        		buffer.newLine();
        				
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
    	static void ActiveRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ActiveRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void PendingRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("PendingRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void DeactivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("DeactivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ActiveDeactivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ActiveDeactivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorDeactivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorDeactivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void PendingDeactivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("PendingDeactivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void PendingActiveRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("PendingActiveRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorActiveRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorActiveRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorPendingRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorPendingRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorPendingActiveRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorPendingRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorPendingDeActivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorPendingDeActivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ErrorActiveDeActivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ErrorActiveDeActivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ActivePendingDeActivatedRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ActivePendingDeActivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on active button: show_active");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void ActivePendingDeActivatedErrorRulesFromMyRulesTable() {
    		Login();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
        		BufferedWriter buffer = new BufferedWriter(fileWriter);  
        		buffer.newLine();
        		buffer.append("ActivePendingDeActivatedRulesFromMyRulesTable");
        		buffer.newLine();
        				
        				try {
        					driver.findElement(By.id("show_pending")).click();
        					buffer.append("Find and click on pending button: show_pending");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_error")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_active")).click();
        					buffer.append("Find and click on error button: show_error");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					driver.findElement(By.id("show_deactivated")).click();
        					buffer.append("Find and click on deactivated button: show_deactivated");
        					buffer.newLine();
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-danger")).size() != 0)
        					{
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					else {
        						
        						buffer.append("Can't Find in my rules table error rule: label label-danger");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-info")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table pending rule: label label-info");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}
        				try {
        					if(driver.findElements(By.className("label label-warning")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table deactivated rule: label label-warning");
            					buffer.newLine();
        					}
        					
        				}catch(IOException exc) {
        					buffer.append(exc.getMessage() );
        					buffer.newLine();
        				}	
        				try {
        					if(driver.findElements(By.className("label label-success")).size() != 0)
        					{
        						
        						buffer.append("Find in my rules table active rule: label label-success");
            					buffer.newLine();
        					}
        					else {
        						buffer.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        						buffer.append("Can't Find in my rules table active rule: label label-success");
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
    	static void RoutesTableLength5() {
    		for(int i = 0; i < 5; i++)
    			AddRule();
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
    		try(FileWriter fileWriter = new FileWriter(".\\logs\\MyRulesReport.txt", true)) {
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
		
		url = configFileReader.getApplicationUrl() + "/altlogin";
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
