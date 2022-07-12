
Feature: Basic Details
  In order to update my basic details
	As a logged user
	should be able to update basic details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  @inprogress
  Scenario: User can discard editing existing basic details

    When I navigate to basic details
    Then basic details landing page is displayed
  	When I choose to edit basic details
    Then basic details page is displayed
    And title first name last name are disabled
    And date of birth ni number nationality are disabled
  	When no details entered
    Then I can not review changes
  	When I enter optional basic contact details
      |  Preferred First Name  | Test   |
      |  Preferred Last Name   | User   |
    And I choose to cancel editing of basic contact details
    And decide to discard entered basic contact details
    Then basic details landing page is displayed

  Scenario: User can review and save new basic contact details

    When I navigate to basic details
    Then basic details landing page is displayed
  	When I choose to edit basic details
    Then basic details page is displayed
  	When  I enter optional basic contact details
      |  Preferred First Name  | Test   |
      |  Preferred Last Name   | User   |
    And I choose to cancel editing of basic contact details
    But again decide to continue editing of basic contact details
    And I review changes in basic details
    And I save changes as final
    Then I should see details are saved
