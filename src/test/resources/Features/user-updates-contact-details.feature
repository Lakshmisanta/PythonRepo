
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
    When I enter phone contact details as below
      |  Primary Home Number | 412147856   |
      |  Personal Mobile     | 58964752368 |
      |  Personal email address     | testuser@gmail.com |
    And I choose to cancel editing of contact details
    And decide to discard entered basic contact details
    Then contact details landing page is displayed

@inprogress
  Scenario: User can  contact details

    When I navigate to contact details
    Then contact details landing page is displayed
    When I choose to edit contact details
    Then contact details page is displayed
    When I enter phone contact details as below
    |  Primary Home Number | 412147856   |
    |  Personal Mobile     | 58964752368 |
    |  Personal email address     | testuser@gmail.com |
    When I enter main address contact details as below
      |  Address line1 |  London100    |
      |  Address line2 |  cheshire add |
      |  Address line3  |  darkshire    |
      |  City           |  Woking       |
      |  County         |  Dorset       |
      | Postcode        | GX4 4DR       |
    And I add alternative address
    When I enter alternative address contact details as below
      |  Address line1    | London100   |
      |  Address line2    | cheshire add |
      |  Address line3     |  darkshire  |
      |  City              |      Woking |
      |  County            | Dorset      |
      | Postcode           | GX4 4DR     |
    And delete alternative address
    And I choose to cancel editing of contact details
    But again decide to continue editing of contact details
    And I add alternative address
    When I enter alternative address contact details as below
      |  Address line1    | London100   |
      |  Address line2    | cheshire add |
      |  Address line3    |  darkshire  |
      |  City             |      Woking |
      |  County           | Dorset      |
      |  Postcode         | GX4 4DR     |
    And I review changes in contact details
    And I save changes in contact details as final
    Then I should see contact details are saved
