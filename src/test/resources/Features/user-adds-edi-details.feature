Feature: Equality, diversity and inclusion

  In order to update Equality, diversity and inclusion details
	As a logged in user
	should be able to add, delete equality, diversity and inclusion under my details.

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  @test
  Scenario: User discards equality, diversity and inclusion details

    When I navigate to equality, diversity and inclusion
    Then edi landing page is displayed
  	When I choose to edit EDI details
    Then edit EDI page is displayed
    When I enter edit details as below
      | Ethnicity          | Other ethinic background |
      | Sexual orientation | Other                    |
    And I choose to cancel entered of edi details
    And decide to discard entered edi details
    Then I am redirected to edi landing page
