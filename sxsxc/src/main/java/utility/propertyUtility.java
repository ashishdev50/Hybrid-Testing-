package utility;

import java.io.FileInputStream;

import java.util.Properties;

import com.aventstack.extentreports.model.Log;

import freemarker.log.Logger;

public class propertyUtility {

//3) here create propertyUtility class and create read propetry  satic method 	
	public static Logger logger = Logger.getLogger("propertyUtility");
public	static  FileInputStream fileInputStream = null;
	
	
	 public static String readproperty(String key) {
		 logger.info("reading a property file for a key:-"+key);
		 Properties properties = new Properties();
		 
		 try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Ashish\\eclipse-workspace\\00\\src\\main\\resources\\config.properties");
			//FileInputStream fileInputStream = new FileInputStream ("C:\\Users\\Ashish\\eclipse-workspace\\HybirdFramework\\src\\main\\resources\\config.properties");
			properties.load(fileInputStream);
		} catch (Exception e) {
        logger.error("value not found in config file");
			e.printStackTrace();
			
		}
		 logger.info("values assigned to the key is found as"+properties.getProperty(key));
	return properties.getProperty(key);
		 
		 
	 }
	
	
}
