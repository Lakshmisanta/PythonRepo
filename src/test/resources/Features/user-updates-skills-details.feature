Feature: Your professional skills

  In order to update my professional skills
	As a logged in user
	should be able to add, delete professional skills under my details.

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  Scenario: User discards the entered skills details

    When I navigate to skills
    Then skills landing page is displayed
  	When I choose to edit skills
    Then edit skills page is displayed
    When I add my professional skills
    And I choose to cancel editing of skills
    And decide to discard entered skills
    Then I am redirected to skills landing page

  @test
  Scenario: User can continue editing, delete and save changes in interests

    When I navigate to skills
    Then skills landing page is displayed
  	When I choose to edit skills
    Then edit skills page is displayed
    When I add my professional skills
    And I choose to cancel editing of skills
    But again decide to continue editing of skills
    And I delete recently added skill
    Then skill should not be displayed in list
    When I add my professional skills
    And I save changes in skill as final
    Then I should see skill is added
