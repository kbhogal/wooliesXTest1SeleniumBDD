
#Sample Feature Definition Template
@Smoke
Feature: Title of your feature2
  I want to use this template for my feature file

   
   Scenario Outline: I want to be able to add n items to the cart and place an order
   Given I am in the login page and signed in as "<username>" and "<password>" 
     And I select <n> items from the home page 
    When I go to checkout and confirm the checkout
     And I confirm the address and shipping details by agreeing to terms of service
     And I confirm the payment options as "<options>" and confirm the order
    Then I should receive a confirmation that the order is complete and awaiting payment
    
    Examples:
    | username                 | password | n  | options          |  
    | kirpalbhogal@gmail.com   | test@123 | 2  | ByCheck          |
    | kirpalbhogal@gmail.com   | test@123 | 3  | BankWire         |