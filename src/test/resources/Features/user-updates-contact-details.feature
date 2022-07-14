@wip
Feature: Contact Details
  In order to update my contact details
	As a logged user
	should be able to update contact details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  Scenario: User can discard editing existing contact details

    When I navigate to contact details
    Then contact details landing page is displayed
  	When I choose to edit contact details
    Then contact details page is displayed
    When I enter contact details as below
      |  Primary Home Number | 412147856   |
      |  Personal Mobile     | 58964752368 |
    And I choose to cancel editing of basic contact details
    And decide to discard entered basic contact details
    Then contact details landing page is displayed

  Scenario: User can  contact details

    When I navigate to contact details
    Then contact details landing page is displayed
    When I choose to edit contact details
    Then contact details page is displayed
    When I enter contact details as below
      |  Primary Home Number | 412147856   |
      |  Personal Mobile     | 58964752368 |
      |  Personal Email Address     | 58964752368 |
    When I enter main address contact details as below
      |  Address line 1    | London100   |
      |  Address line 2    | cheshire add |
      |  Adress line 3     |  darkshire  |
      |  City              |      Woking |
      |County              |  Dorset     |
      |Postcode |GX4 4DR|
    When I enter main address contact details as below
        |  Address line 1    | London100   |
        |  Address line 2    | cheshire add |
        |  Adress line 3     |  darkshire  |
        |  City              |      Woking |
        |County| Dorset|
        |Postcode |GX4 4DR|

    And I choose to cancel editing of basic contact details
    But again decide to continue editing of basic contact details
    And I review changes in basic details
    And I save changes as final
    Then I should see details are saved
