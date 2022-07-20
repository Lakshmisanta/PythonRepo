Feature: Equality, diversity and inclusion

  In order to update Equality, diversity and inclusion details
	As a logged in user
	should be able to add, delete equality, diversity and inclusion under my details.

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

Scenario: User discards equality, diversity and inclusion details

    When I navigate to equality, diversity and inclusion
    Then edi landing page is displayed
  	When I choose to edit EDI details
    Then edit EDI page is displayed
    When I enter edit details as below
      | Ethnicity   | Prefer not to say |
      | Religion    | Hindu             |
    And I choose to cancel entered of edi details
    And decide to discard entered edi details
    Then I am redirected to edi landing page

 @test
Scenario: User discards equality, diversity and inclusion details

    When I navigate to equality, diversity and inclusion
    Then edi landing page is displayed
  	When I choose to edit EDI details
    Then edit EDI page is displayed
    When I enter edi details as below
      | Ethnicity          | White   |
      | Religion           | Jewish  |
      | Gender             | Male    |
      | sex at birth       | Yes     |
      | sexual orientation | Asexual |
    And I choose to cancel editing of edi details
    But again decide to continue editing of edi details
    When I enter edi details as below
      | Ethnicity   | Asian or Asian British - Indian |
      | Religion    | Sikh                            |
      | Gender      | Female                          |
    And I review changes in edi details
    And I cancel reviewed changes in edi details
    Then edit EDI page is displayed
    When I enter edi details as below
      | Ethnicity          | White - British |
      | sex at birth       | Yes             |
      | sexual orientation | Asexual         |
    When again I review changes in edi details
    And I save changes in edi details as final
    Then I should see edi details are saved
