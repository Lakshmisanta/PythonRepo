Feature: My Details
  In order to update my details
	As a logged user
	should be able to add , edit and cancel emergency details

Background:
	Given login application URL
	Then navigate to mydetails page

@emergency
Scenario: User can add emergency contact details

	Given I navigate to emergency contact details
	Then I should see emergency contact details
	When I click add emergency contact
	Then I enter mandatory details
		| Fields                 | Values              |
		| Relationship           | Brother             |
		| Last Name              | Luke               |
		| Address1               | 35 A                |
		| Address2               | Foxhole Rd          |
	Then I enter optional details
		| Fields                 | Values              |
		| Title            		   | Mr              	   |
		| First Name             | Peter               |
		| Email               	 | EmergencyContacts@gmail.com |
    | Primary home number    | 	01278 457474       |
		| Personal mobile        | 	01278 457474       |
    | Work number            | 	01278 457474       |
    | Address3               | Near River Bank     |
    | City                   | Chorley             |
    | County                 | Lancashire          |
    | Postcode               | PR7 1NY             |
  And I choose to cancel contact details
  But again decide to continue editing contact details
  And I choose to review changes
  And I cancel to review changes
  Then I am redirected to add emergency contact page
	When I choose to review changes
	And I save changes to add contact details
  Then emergency contact is added

@wip
Scenario: User can discard emergency contact details

  Given I navigate to emergency contact details
  Then I should see emergency contact details
  When I click add emergency contact
  Then I enter mandatory details
    | Fields                 | Values              |
    | Relationship           | Brother             |
    | Last Name              | Luke               |
    | Address1               | 35 A                |
    | Address2               | Foxhole Rd          |
  Then I enter optional details
    | Fields                 | Values              |
    | Title            		   | Mr              	   |
    | First Name             | Peter               |
    | Email               	 | EmergencyContacts@gmail.com |
    | Primary home number    | 	01278 457474       |
    | Personal mobile        | 	01278 457474       |
    | Work number            | 	01278 457474       |
    | Address3               | Near River Bank     |
    | City                   | Chorley             |
    | County                 | Lancashire          |
    | Postcode               | PR7 1NY             |
  And I choose to cancel contact details
  And decide to discard contact details
  Then I am redirected to emergency contact landing page
