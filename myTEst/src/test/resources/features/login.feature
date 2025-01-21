#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: User Login
  @S1 @smoke
  Scenario: Successful login with valid credentials S1
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should be redirected to the homepage
    Then Close browser
    
    @S2 @smoke
  Scenario: Successful login with valid credentials S2
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should be redirected to the homepage
    Then Close browser