
Feature: Interest Details
  In order to update my interest details
	As a logged in user
	should be able to update phone , main and alternate contact details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page


  Scenario: User can discard editing interests

    When I navigate to interests
    Then interests landing page is displayed
  	When I choose to edit interests
    Then edit interests page is displayed
    When I add my interest details
    And I choose to cancel editing of interest details
    And decide to discard entered interests
    Then I am redirected to interests landing page

@test
  Scenario: User can continue editing and save changes in Interests

    When I navigate to interests
    Then interests landing page is displayed
    When I choose to edit interests
    Then edit interests page is displayed
    When I add my interest details
    And I choose to cancel editing of interest details
    But again decide to continue editing of interests
    And I delete recently added interest
    Then interest should not be displayed in list
    When I add my interest details
    #And I save changes in intersts as final
    #Then I should see interest is added
