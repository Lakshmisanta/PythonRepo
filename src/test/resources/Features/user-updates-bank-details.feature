
Feature: Bank Details
  In order to update my bank details
	As a logged user
	should be able to update bank details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  Scenario: User can cancel and discard editing existing bank details

    When I navigate to bank details
    Then bank details landing page is displayed
  	When I choose to edit bank details
    Then bank details page is displayed
  	When I enter bank details as
       |  Account holder's name  | Test User |
    But I choose to cancel editing of bank contact details
    Then bank details landing page is displayed
    When I again choose to edit bank details
    When I enter bank details as
      |  Account holder's name  | Test User |
      |  Account number         | 29823529  |
      |  Sort code              | 902127    |
    Then bank name and branch is disabled
    When I choose to cancel editing of bank contact details
    And decide to discard entered bank details
    Then bank details landing page is displayed

  @inprogress
  Scenario: User can continue editing bank details and save after reviewing changes

    When I navigate to bank details
    Then bank details landing page is displayed
  	When I choose to edit bank details
    Then bank details page is displayed
    When I enter bank details as
      |  Account holder's name  | Test User |
      |  Account number         | 29823529  |
      |  Sort code              | 902127    |
    When I choose to cancel editing of bank contact details
    But continue editing entered bank details
    And I review changes in bank details
    And I cancel reviewed changes in bank details
    Then bank details page is displayed
