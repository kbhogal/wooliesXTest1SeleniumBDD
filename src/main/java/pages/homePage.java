package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class homePage {

	public By qTextbox = By.id("search_query_top");
	
	public By imgFirst = By.xpath("//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img");
	
	public By loginBtn = By.xpath("//a[@class='login']");
	
	public By homeProductItems = By.xpath("//*[@id='homefeatured']/li"); 
	
	public By addToCart = By.xpath("//p[@id='add_to_cart']/button"); 
	
	public By logoClick = By.xpath("//*[@id='header_logo']/a/img"); 
	
	public By continueShopping = By.cssSelector(".button.exclusive-medium span"); 
	
	public By goToCart = By.xpath("//div[@class='shopping_cart']/a"); 
	
	public By signIn = By.xpath("//a[@class='login']"); 
	
	
	public void signInClick(WebDriver driver) { 
		driver.findElement(signIn).click(); 
	}

    public void goToCartClick(WebDriver driver) { 
	driver.findElement(goToCart).click();		
	}
    public void loginBtnClick(WebDriver driver) { 
	driver.findElement(loginBtn).click();		
	}
	
	public void typeQTextbox(String s, WebDriver driver) { 	
	driver.findElement(qTextbox).sendKeys(s); 
	}
	
	public void clickImage( WebDriver driver) { 
	driver.findElement(imgFirst).click();
	}
	
	
	
	public void addToCartClick(WebDriver driver) { 
		driver.findElement(addToCart).click();
	}
	
	
	public void continueShoppingClick(WebDriver driver) { 
		driver.findElement(continueShopping).click();
	}

	public void clickLogoClick(WebDriver driver) {
		driver.findElement(logoClick).click(); 

	}

	

	
	
	
	public void addItemsToTheCart(WebDriver driver, int nItems) {
		
		int i1=1; 
		
		System.out.println(nItems);

		Actions action = new Actions(driver);
		
		List<WebElement> pList = driver.findElements(homeProductItems);
		System.out.println("size " + pList.size()); 
		
		for( WebElement i: pList){
			
			// hover over and click the item
			action.moveToElement(i).perform();
			i.click(); 
			
			driver.findElement(By.xpath("//*[@id='homefeatured']/li[" + i1 + "]/div")).click();
			
			driver.findElement(addToCart).click();
			
			driver.findElement(continueShopping).click();
						
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(logoClick).click(); 


			

		    
	      }
		
	//	driver.quit();
	     }
		}
