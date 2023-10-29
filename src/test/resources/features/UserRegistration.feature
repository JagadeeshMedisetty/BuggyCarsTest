Feature: User Registration 
	As a user, I need to register with the website so that I can login and Vote for my favourite car


Background: 
Given user is not registered with application

  @registration
  @SmokeTest
  Scenario Outline: User registers with valid password
     Given user enters valid username <username>
     And user enters valid firstname <firstname>
     And user enters valid lastname <lastname>
     And user enters valid password <password>
     And user enters valid confirmpassword <confirmpassword>
     When user submit Register
     Then user registration should be successful
    Examples: 
      | username      | firstname | lastname | password    | confirmpassword | 
      | random        | sya       | Tom      | Password@123| Password@123    |
      
  @registration
  Scenario Outline: User registers with invalid password
    Given user enters valid username <username>
    And user enters valid firstname <firstname>
    And user enters valid lastname <lastname>
    And user enters invalid password <password>
    And user enters invalid confirmpassword <confirmpassword>
    When user submit Register
    Then user registration should be unsuccessful
  
    Examples: 
      | username      | firstname | lastname | password    | confirmpassword | 
      | random        | sya       | Tom      | password    | password        |

  @registration
  Scenario: Same user tries to register again
    Given user is already registered with th website
    When user tries to register with the same username
    Then user registration should not be successful
    And Validation message displayed as user already registered