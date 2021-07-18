package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class paymentPage {

	public By payBankWire = By.className("bankwire"); 
	public By payByCheque = By.className("cheque"); 
	
	public By btnOrderConfirm = By.xpath("//*[@id='cart_navigation']/button"); 
	
	public By orderConfirmText = By.xpath("//*[@id=\"center_column\"]/p[1]"); 


	
	public void clickPayByBankWire(WebDriver driver) { 
		
		driver.findElement(payBankWire).click();
	}
	
	
	public void clickPayByCheque(WebDriver driver) { 
		
		driver.findElement(payByCheque).click();
	}
	
	public void submitOrderConfirmation(WebDriver driver) { 
		
		driver.findElement(btnOrderConfirm).click();
		
	}
	
	public String getConfirmationText(WebDriver driver) {
		return driver.findElement(orderConfirmText).getAttribute("outerText").toString(); 
		
	}
	

}
