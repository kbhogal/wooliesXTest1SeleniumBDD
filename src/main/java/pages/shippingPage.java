package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class shippingPage {

	
	public By cTermsCondition = By.id("cgv"); 
	public By bCheckOut = By.name("processCarrier"); 
	
	public void checkTermsConditions(WebDriver driver) { 
		
		driver.findElement(cTermsCondition).click();
	}
	
	public void submitCareer(WebDriver driver) { 
		
		driver.findElement(bCheckOut).click();
	}
	
	

}
