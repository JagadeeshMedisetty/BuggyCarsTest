@auth
Feature: Buggy Cars Rating Login Functionality
	In order to maintain identity of users
	As a product owner
	I want to add login functionality to BCR website

@login
@SmokeTest
Scenario: Login with valid credentials
	Given browser is open
	And user launches the home page
	When user login with valid credentials
	Then Website should be in a logged in state

@login
Scenario: Login with invalid credentials
	Given browser is open
	And user launches the home page
	When user login with invalid credentials
	Then Website should not be in a logged in state

@logout
Scenario: Log out
	Given browser is open
	And user launches the home page
	Given website is in a logged in state
	When user logs out
	Then website should be in a logged out state
