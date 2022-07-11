@inprogress
Feature: Basic Details
  In order to update my basic details
	As a logged user
	should be able to update basic details

  Background:
  	Given I am logged onto UCL as a registered user
  	Then I navigate to mydetails page

  Scenario: User can update basic details

    When I navigate to basic details
    Then basic details landing page is displayed
  	When I choose to edit basic details
    Then basic details page is displayed
    And Title Firstname Lastname are disbaled

  	#And DOB NI number Nationality should not get edited
    #And date of brith ni number Nationality are disabled
  	#When No details entered then review changes is disabled
  	#Then I should enter optional basic details
  	#Then review changes button is Enabled
  	#Then I click on Cancel then continue editing
  	#Then I click on review changes
  	#And I click on Save changes
