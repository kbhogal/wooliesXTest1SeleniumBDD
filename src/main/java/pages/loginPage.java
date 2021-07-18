package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage {

	public By sLoginEmail = By.id("email");
    public By sPassword = By.id("passwd"); 
    public By bSubmit = By.id("SubmitLogin"); 
	
	public void loginEnterEmail(WebDriver driver, String email) { 
		
		driver.findElement(sLoginEmail).sendKeys(email); 
	}
	
	public void loginEnterPass(WebDriver driver, String pass) { 
		
		driver.findElement(sPassword).sendKeys(pass); 
	}
	
	public void loginSubmit(WebDriver driver) { 
		
		driver.findElement(bSubmit).click();
	}
	
	
	

}
