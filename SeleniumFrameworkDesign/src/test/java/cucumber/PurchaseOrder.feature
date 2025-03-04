
@tag
Feature: Title of your feature
  I want to use this template for my feature file

Background: 
Given I landed on the eCommerce homePage

  @tag2
  Scenario Outline: Positive test for submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <prodcutName> to the cart
    And Go to checkout with the product <productName> and submit the order
    Then Confirmation message "THANK YOU FOR THE ORDER." message will display on ConfirmationPage

    Examples: 
      | name   		 | password	 | productName  	|
      |ansu@xyz.com| Ansuman1@3| ZARA COAT 3    |
