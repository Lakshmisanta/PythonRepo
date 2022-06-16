Feature: Home Page links Redirects Successfully

@alreadyLoggedIn
@SanityTest
Scenario: Check Links

Given I navigate to Inside UCL app
When I login to application
And I click on Mydetails Tile 
Then I should see Mydetails page
When I click on MyTimeOff Tile
Then I should see MyTimeOff page	


