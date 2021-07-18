package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class addressPage {

	
	public By bCheckOut = By.name("processAddress"); 
	

	
	public void checkOutSubmit(WebDriver driver) { 
		
		driver.findElement(bCheckOut).click();
	}
	
	
	

}
