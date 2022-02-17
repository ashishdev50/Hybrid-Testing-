package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class Loginpage extends Base {
	
	
	
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	
	@FindBy(id="//button")
	private WebElement loginBtn;
	
	public  Loginpage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
			
		
	}

	 public void  loginApplication() {
		   uname.sendKeys("kiran@gmail.com");
           pass.sendKeys("12345");
	       loginBtn.click();
		
	}
	
	
	

}
