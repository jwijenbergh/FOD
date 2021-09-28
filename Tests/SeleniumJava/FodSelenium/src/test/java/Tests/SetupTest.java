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

public class SetupTest {

        static WebDriver driver;
    
        static String url;
        
        static ConfigFileReader configFileReader = new ConfigFileReader();

	@Test
	public static void OnlyPassword() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("OnlyPassword");
			buffer.newLine();
					try {
						driver.get(url);
						buffer.append("Go to url: "+ url );
						buffer.newLine();
					}catch(IOException exc) {
						buffer.append(exc.getMessage() );
						buffer.newLine();
					}
					boolean flag_to_stop = false;
					  try{

						driver.findElement(By.id("access_denied_id"));
					    flag_to_stop = true;
					    buffer.append("Find access denied: access_denied_id");
						buffer.newLine();
					  }
					   catch(Exception e){
						   buffer.append(exc.getMessage() );
							buffer.newLine();
					    flag_to_stop = false;
					  }
					if(!flag_to_stop)
					{
						try {
							driver.findElement(By.id("id_password")).click();
							buffer.append("Find password: id_password ");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("id_password")).sendKeys(configFileReader.getUserPassword());
							buffer.append("Put password: "+ configFileReader.getUserPassword());
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("applybutton")).click();
							buffer.append("Find apply button: applybutton");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
	    					WebElement inputName = driver.findElement(By.id("id_netconf_device"));
	    					JavascriptExecutor js = (JavascriptExecutor) driver;  
	    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
	    					if(isRequired )
	    					{
	    						buffer.append("Find required attribute: id_netconf_device");
	    						buffer.newLine();
	    					}else {
	    						buffer.append("!!!!!!!!!!");
	    						buffer.append("FAILED: Find required attribute: id_netconf_device");
	    						buffer.newLine();
	    					}
	    					
	    				}catch(IOException exc) {
	    					buffer.append(exc.getMessage());
	    					buffer.newLine();
	    				}
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
	public static void OnlyNotSavePassword() 
        {
		try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("OnlyNotSavePassword");
			buffer.newLine();
					try {
						driver.get(url);
						buffer.append("Go to url: "+ url );
						buffer.newLine();
					}catch(IOException exc) {
						buffer.append(exc.getMessage() );
						buffer.newLine();
					}
					boolean flag_to_stop = false;
					  try{

						driver.findElement(By.id("access_denied_id"));
					    flag_to_stop = true;
					    buffer.append("Find access denied: access_denied_id");
						buffer.newLine();
					  }
					   catch(Exception e){
						   buffer.append(exc.getMessage() );
							buffer.newLine();
					    flag_to_stop = false;
					  }
					if(!flag_to_stop)
					{
						try {
							driver.findElement(By.id("id_password")).click();
							buffer.append("Find password: id_password ");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("id_password")).sendKeys("1");
							buffer.append("Put password: 1");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("applybutton")).click();
							buffer.append("Find apply button: applybutton");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
	    					WebElement inputName = driver.findElement(By.id("id_netconf_device"));
	    					JavascriptExecutor js = (JavascriptExecutor) driver;  
	    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
	    					if(isRequired )
	    					{
	    						buffer.append("Find required attribute: id_netconf_device");
	    						buffer.newLine();
	    					}else {
	    						buffer.append("!!!!!!!!!!");
	    						buffer.append("FAILED: Find required attribute: id_netconf_device");
	    						buffer.newLine();
	    					}
	    					
	    				}catch(IOException exc) {
	    					buffer.append(exc.getMessage());
	    					buffer.newLine();
	    				}
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
		//public static void OnlyRouterHost(WebDriver driver, String url) 
		public static void OnlyRouterHost() 
		{try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
			BufferedWriter buffer = new BufferedWriter(fileWriter);  
			buffer.newLine();
			buffer.append("OnlyRouterHost");
			buffer.newLine();
					try {
						driver.get(url);
						buffer.append("Go to url: "+ url );
						buffer.newLine();
					}catch(IOException exc) {
						buffer.append(exc.getMessage() );
						buffer.newLine();
					}
					boolean flag_to_stop = false;
					  try{

						driver.findElement(By.id("access_denied_id"));
					    flag_to_stop = true;
					    buffer.append("Find access denied: access_denied_id");
						buffer.newLine();
					  }
					   catch(Exception e){
						   buffer.append(exc.getMessage() );
							buffer.newLine();
					    flag_to_stop = false;
					  }
					if(!flag_to_stop)
					{
						try {
							driver.findElement(By.id("id_netconf_device")).click();
							buffer.append("Find netconf device: id_netconf_device ");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("id_netconf_device")).sendKeys("1.0.0.0");
							buffer.append("Put netconf device: 1.0.0.0");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
							driver.findElement(By.id("applybutton")).click();
							buffer.append("Find apply button: applybutton");
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						try {
	    					WebElement inputName = driver.findElement(By.id("id_password"));
	    					JavascriptExecutor js = (JavascriptExecutor) driver;  
	    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyWrongRouterHost(WebDriver driver, String url) 
		public static void OnlyWrongRouterHost() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyWrongRouterHost");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_device")).click();
								buffer.append("Find netconf device: id_netconf_device ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_device")).sendKeys("<>");
								buffer.append("Put netconf device: <>");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		public static void OnlyRouterPort() 
                {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyRouterPort");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_port")).click();
								buffer.append("Find netconf port: id_netconf_port ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_port")).sendKeys("22");
								buffer.append("Put netconf port: 22");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		public static void OnlyWrongRouterPort() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyWrongRouterPort");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_port")).click();
								buffer.append("Find netconf port: id_netconf_port ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_port")).sendKeys("<>");
								buffer.append("Put netconf port: <>");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyRouterUser(WebDriver driver, String url) 
		public static void OnlyRouterUser() 
                {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyRouterUser");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_user")).click();
								buffer.append("Find netconf user: id_netconf_user ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_user")).sendKeys("user");
								buffer.append("Put netconf user: user");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyWrongRouterUser(WebDriver driver, String url) 
		public static void OnlyWrongRouterUser() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyWrongRouterUser");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_user")).click();
								buffer.append("Find netconf user: id_netconf_user ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_user")).sendKeys("<>");
								buffer.append("Put netconf user: <>");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyRouterPassword(WebDriver driver, String url) 
		public static void OnlyRouterPassword() 
                {
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyWrongRouterUser");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_pass")).click();
								buffer.append("Find netconf password: id_netconf_pass ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_pass")).sendKeys("Gf1!grGR00");
								buffer.append("Put netconf password: Gf1!grGR00");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyNotSaveRouterPassword(WebDriver driver, String url) 
		public static void OnlyNotSaveRouterPassword() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyNotSaveRouterPassword");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_netconf_pass")).click();
								buffer.append("Find netconf password: id_netconf_pass ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_pass")).sendKeys("1");
								buffer.append("Put netconf password: 1");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyTestIP(WebDriver driver, String url) 
		public static void OnlyTestIP() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyTestIP");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_test_peer_addr")).click();
								buffer.append("Find test peer address: id_test_peer_addr ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_test_peer_addr")).sendKeys("0.0.0.0/30");
								buffer.append("Put test peer address: 0.0.0.0/30");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void OnlyWrongTestIP(WebDriver driver, String url) 
		public static void OnlyWrongTestIP() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("OnlyWrongTestIP");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_test_peer_addr")).click();
								buffer.append("Find test peer address: id_test_peer_addr ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_test_peer_addr")).sendKeys("<>");
								buffer.append("Put test peer address: <>");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
		    					WebElement inputName = driver.findElement(By.id("id_password"));
		    					JavascriptExecutor js = (JavascriptExecutor) driver;  
		    					boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputName);
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
		//public static void GoodData(WebDriver driver, String url) 
		public static void GoodData() 
		{
			try(FileWriter fileWriter = new FileWriter(".\\logs\\setupReport.txt", true)) {
				BufferedWriter buffer = new BufferedWriter(fileWriter);  
				buffer.newLine();
				buffer.append("GoodData");
				buffer.newLine();
						try {
							driver.get(url);
							buffer.append("Go to url: "+ url );
							buffer.newLine();
						}catch(IOException exc) {
							buffer.append(exc.getMessage() );
							buffer.newLine();
						}
						boolean flag_to_stop = false;
						  try{

							driver.findElement(By.id("access_denied_id"));
						    flag_to_stop = true;
						    buffer.append("Find access denied: access_denied_id");
							buffer.newLine();
						  }
						   catch(Exception e){
							   buffer.append(exc.getMessage() );
								buffer.newLine();
						    flag_to_stop = false;
						  }
						if(!flag_to_stop)
						{
							try {
								driver.findElement(By.id("id_password")).click();
								buffer.append("Find password: id_password ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_password")).sendKeys(configFileReader.getUserPassword());
								buffer.append("Put password: "+ configFileReader.getUserPassword());
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_device")).click();
								buffer.append("Find netconf device: id_netconf_device ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_device")).sendKeys("1.0.0.0");
								buffer.append("Put netconf device: 1.0.0.0");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_port")).click();
								buffer.append("Find netconf port: id_netconf_port ");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_port")).sendKeys("29");
								buffer.append("Put netconf port: 29");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_user")).click();
								buffer.append("Find netconf user: id_netconf_user");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_user")).sendKeys("user");
								buffer.append("Put netconf user: user");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_pass")).click();
								buffer.append("Find netconf password: id_netconf_pass");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_netconf_pass")).sendKeys("Gf12!grGR00");
								buffer.append("Put netconf password: Gf12!grGR00");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_test_peer_addr")).click();
								buffer.append("Find test peer address: id_test_peer_addr");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("id_test_peer_addr")).sendKeys("1.0.0.0/8");
								buffer.append("Put test peer address: 1.0.0.0/8");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							try {
								driver.findElement(By.id("applybutton")).click();
								buffer.append("Find apply button: applybutton");
								buffer.newLine();
							}catch(IOException exc) {
								buffer.append(exc.getMessage() );
								buffer.newLine();
							}
							//TODO: find how to check if main page
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
		
		url =  configFileReader.getApplicationUrl() + "/altlogin";;

	}

	public static void main(String[] args) {

                testSetUp();

		OnlyPassword();
	
			
		testSetDown();

	}
	
	@AfterClass	
	static void testSetDown() {
		
		//closing the browser
		driver.close();
	
	}
}
