
Feature: Interest Details
  In order to update my interest details
	As a logged in user
	should be able to update phone , main and alternate contact details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  @test
  Scenario: User can discard editing existing contact details

    When I navigate to interest details
    Then contact interest landing page is displayed
  	When I choose to edit interest details
    Then interest details page is displayed
    When I add my interest details
    And I choose to cancel editing of interest details
    And decide to discard entered interest details
    Then I am on interest details landing page

  Scenario: User can discard and save changes in main and alternate address contact details

    When I navigate to contact details
    Then contact details landing page is displayed
    When I choose to edit contact details
    Then contact details page is displayed
    When I enter phone contact details as below
      |  Primary Home Number    | random          |
      |  Personal Mobile        | random        |
      |  Personal email address | testuser@gmail.com |
    When I enter main address contact details as below
      |  Address line1  |  100 Bake Street |
      |  Address line2  |  cheshire add    |
      |  Address line3  |  darkshire       |
      |  City           |  Woking          |
      |  County         |  Dorset          |
      | Postcode        | GX4 4DR          |
    And I add alternative address
    When I enter alternative address contact details as below
      |  Address line1  | 72 Great North Road |
      |  Address line2  | Manor Close |
      |  Address line3  | Darkshire   |
      |  City           | Butterton   |
      |  County         | Dorset      |
      | Postcode        | B61 7LP     |
    And delete alternative address
    And I choose to cancel editing of contact details
    But again decide to continue editing of contact details
    And I add alternative address
    When I enter alternative address contact details as below
      |  Address line1    | London100   |
      |  Address line2    | cheshire add |
      |  Address line3    |  darkshire  |
      |  City             |  Woking |
      |  County           | Dorset      |
      |  Postcode         | GX4 4DR     |
    And I review changes in contact details
    And I save changes in contact details as final
    Then I should see contact details are saved
