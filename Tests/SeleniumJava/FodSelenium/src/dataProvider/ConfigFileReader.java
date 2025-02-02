package dataProvider;

 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 private Properties properties;
	 private final String propertyFilePath= "configs//Configuration.properties";
	 
	 
	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getDriverPath(){
	 String driverPath = properties.getProperty("driverPath");
	 if(driverPath!= null) return driverPath;
	 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 }
	 
	 public long getImplicitlyWait() { 
	 String implicitlyWait = properties.getProperty("implicitlyWait");
	 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
	 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	 }
	 
	 public String getApplicationUrl() {
	 String url = properties.getProperty("url");
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the Configuration.properties file.");
	 }
	 
	 public String getUserLogin() {
		 String login = properties.getProperty("login");
		 if(login != null) return login;
		 else throw new RuntimeException("login not specified in the Configuration.properties file.");
		 }
	 
	 public String getUserPassword() {
		 String password = properties.getProperty("password");
		 if(password != null) return password;
		 else throw new RuntimeException("login not specified in the Configuration.properties file.");
		 }
	 
	 public String getSourceIPAddress() {
		 String sourceIPAddress = properties.getProperty("sourceIPAddress");
		 if(sourceIPAddress != null) return sourceIPAddress;
		 else throw new RuntimeException("source ip address not specified in the Configuration.properties file.");
		 }
	 
	 public String getDestinationIPAddress() {
		 String destinationIPAddress = properties.getProperty("destinationipaddress");
		 if(destinationIPAddress != null) return destinationIPAddress;
		 else throw new RuntimeException("destination ip address not specified in the Configuration.properties file.");
		 }
	 
	 public String getRuleName() {
		 String ruleName = properties.getProperty("ruleName");
		 if(ruleName != null) return ruleName;
		 else throw new RuntimeException("rule Name not specified in the Configuration.properties file.");
		 }
	 
	 public String getSQLURL() {
		 String SQLURL = properties.getProperty("SQLURL");
		 if(SQLURL != null) return SQLURL;
		 else throw new RuntimeException("SQLURL not specified in the Configuration.properties file.");
		 }
	 
	 public String getSQLUsr() {
		 String SQLUsr = properties.getProperty("SQLUsr");
		 if(SQLUsr != null) return SQLUsr;
		 else throw new RuntimeException("SQLUsr not specified in the Configuration.properties file.");
		 }
	 
	 public String getSQLPass() {
		 String SQLPass = properties.getProperty("SQLPass");
		 if(SQLPass != null) return SQLPass;
		 else throw new RuntimeException("SQLPass not specified in the Configuration.properties file.");
		 }
	 public String getAPIToken() {
		 String APIToken = properties.getProperty("APIToken");
		 if(APIToken != null) return APIToken;
		 else throw new RuntimeException("APIToken not specified in the Configuration.properties file.");
		 }
	 public String getSpecificItemIdForRESTAPI() {
		 String SpecificItemIdForRESTAPI = properties.getProperty("SpecificItemIdForRESTAPI");
		 if(SpecificItemIdForRESTAPI != null) return SpecificItemIdForRESTAPI;
		 else throw new RuntimeException("SpecificItemIdForRESTAPI not specified in the Configuration.properties file.");
		 }
}
