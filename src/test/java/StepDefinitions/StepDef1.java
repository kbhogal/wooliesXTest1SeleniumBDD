package StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.addressPage;
import pages.homePage;
import pages.loginPage;
import pages.orderPage;
import pages.paymentPage;
import pages.shippingPage;


public class StepDef1 {

	
       static WebDriver driver; 
       homePage pageone;  

      
      @Given("^I am in the login page and signed in as \"([^\"]*)\" and \"([^\"]*)\"$")
      public void i_am_in_the_login_page_and_signed_in_as_and(String email, String pass) {
          // Write code here that turns the phrase above into concrete actions
  		System.setProperty("webdriver.chrome.driver","/Users/kirpal/Downloads/chromedriver");
  		 
  		 driver =new ChromeDriver(); 
  		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		 
  		 driver.get("http://automationpractice.com/index.php");
  	     pageone =new homePage();
  	     pageone.signInClick(driver); 
  	     
  	     loginPage loginpage = new loginPage(); 
  	     loginpage.loginEnterEmail(driver, email); 
  	     loginpage.loginEnterPass(driver, pass);
  	     
  	     loginpage.loginSubmit(driver);
  		 
  	     pageone.clickLogoClick(driver);
  	
       
	    }
        
    

      @Given("^I select (\\d+) items from the home page$")
      public void i_select_items_from_the_home_page(int nItems) {
        pageone =new homePage();
        //  pageone.loginBtnClick(driver); 

  		int i1=1; 


  		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
  		
  		 List<WebElement> pList = driver.findElements(By.xpath("//*[@id='homefeatured']/li"));
  		
  		//loop through products and add n number, it uses window handle to navigate between pages
  	     for( WebElement i: pList){

  			 Actions action = new Actions(driver); 
  			 WebDriverWait wait = new WebDriverWait(driver,30);

  	         wait.until(ExpectedConditions.elementToBeClickable(i)).click();
  
  			 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homefeatured']/li[" + i1 + "]/div")));
        	 action.keyDown(Keys.COMMAND).click(element1).keyUp(Keys.COMMAND).perform();
	    	 
	    	 tabs = new ArrayList<String> (driver.getWindowHandles());
	    	 driver.switchTo().window(tabs.get(1));

	    	 pageone.addToCartClick(driver);			
  	         wait.until(ExpectedConditions.elementToBeClickable(pageone.continueShopping)).click();;
   		

  			 driver.switchTo().window(tabs.get(1)).close();
  	    	 driver.switchTo().window(tabs.get(0));
  	    	 
  			  if(i1==nItems) break; 
  			  i1++; 
  	      }

           	  pageone.goToCartClick(driver);       	  
  		
      }

      @When("^I go to checkout and confirm the checkout$")
      public void i_go_to_checkout_and_confirm_the_checkout()  {
    	  
    	  
    	  orderPage orderpage = new orderPage(); 
    	  
    	  orderpage.checkOutSubmit(driver);


      }

      @When("^I confirm the address and shipping details by agreeing to terms of service$")
      public void i_confirm_the_address_and_shipping_details_by_agreeing_to_terms_of_service()  {

          addressPage addresspage = new addressPage(); 
          
          addresspage.checkOutSubmit(driver);
          
      }

      @When("^I confirm the payment options as \"([^\"]*)\" and confirm the order$")
      public void i_confirm_the_payment_options_as_and_confirm_the_order(String payOption)  {
        shippingPage shipPage = new shippingPage(); 
        shipPage.checkTermsConditions(driver);
        shipPage.submitCareer(driver);
        
        paymentPage paypage = new paymentPage(); 
        
        if (payOption =="BankWire") {
        paypage.clickPayByBankWire(driver);
        paypage.submitOrderConfirmation(driver); 
        
        } else {
        	
        	 paypage.clickPayByCheque(driver);
        	 paypage.submitOrderConfirmation(driver); 
        }
 
        
      }

      @Then("^I should receive a confirmation that the order is complete and awaiting payment$")
      public void i_should_receive_a_confirmation_that_the_order_is_complete_and_awaiting_payment() throws InterruptedException {
    	  paymentPage paypage = new paymentPage(); 
    	  Assert.assertTrue(paypage.getConfirmationText(driver).startsWith("Your order on My Store is complete", 0)); 
    	  Thread.sleep(5000);
    	  
    	  driver.quit(); 
      }
      



}
