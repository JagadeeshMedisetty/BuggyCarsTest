Feature: User Voting
	As a user I need to be able to vote to my favourite car

@voting
@SmokeTest
Scenario: User votes for his favourite car
	Given User is registered and logged in
	And he did not already vote for a car
	When he votes for a car
	Then the vote should be recorded
	And vote should be displayed in voting history

	@voting
Scenario: User already voted for a car
	Given User is registered and logged in
	And he already placed his vote for a car
	When he opens the car voting page
	Then he should not be able to vote again


