package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class orderPage {

	
	public By bCheckOut = By.xpath("//*[@id='center_column']/p[2]/a[1]"); 
	

	
	public void checkOutSubmit(WebDriver driver) { 
		
		driver.findElement(bCheckOut).click();
	}
	
	
	

}
