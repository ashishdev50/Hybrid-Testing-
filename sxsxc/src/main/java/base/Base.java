package base;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.propertyUtility;


public class Base {
//2) create base classs and create the intilization method 
	// this class should have all common code
	
	public static Logger logger = Logger.getLogger("Baseclass");
	   public static WebDriver driver = null;
	   public static ExtentReports report = null;
	   public static ExtentSparkReporter spark = null;
	   public static ExtentTest test = null;
	   
	   public static void initilization () {
		   System.out.println("initilization browser");
		   logger.info("initilization browser");// here we use loogger  for conole print all detail its advanced than syso
		   String browser = propertyUtility.readproperty("browser");
		  
		 
		       if(browser.equals("chrome")) {
	   
			   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashish\\eclipse-workspace\\00\\target\\chromedriver.exe");
			   driver = new ChromeDriver();			   			   			   
		   }       
		       driver.manage().window().maximize();
		       driver.get(propertyUtility.readproperty("url"));
		       driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	       	 	   
	  }
	   
  
	public void reportInit()
	   {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		//spark = new ExtentSparkReporter("C:\\Users\\Ashish\\eclipse-workspace\\HybirdFramework\\target");
		report.attachReporter(spark);
			
		
	   }
	public String takesScreenshot(String name)
	 {
		 
		 TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source= screenshot.getScreenshotAs(OutputType.FILE);
		 
            String path = System.getProperty(("user.dir")+"/screenshots/"+name+".jpg");
            File file = new File(path);
            try {
				FileUtils.copyFile(source, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return path;
		 
	 }
	
	  		
}
