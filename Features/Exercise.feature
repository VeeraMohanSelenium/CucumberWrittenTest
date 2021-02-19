Feature: Title of your feature 
	I want to use this template for my feature file


Scenario: 
	As per the user story to validate the exercise values functionality of the Exercise 

	Given I want to launch the Chrome browser
	When it maximizes enter the URL
		|https://www.ecercise1.com/values| 
	Then I need to verify the right count of the values appear on the screen
	Then Need to verify the values on the screen are greater then zero
	And Need to verify the total balance is correct based values listed on screen
	Then Verify the values are formatted as currencies
	Then Verify the total balance matches the sum of the values