Feature: 	Disability's functionality
Impersonate User 

Background:
	Given login application URL
	Then Navigate to mydetails page

Scenario: User can discard disability details

Given I click on the Disability link
When  I click  on the Add a Disability button
Then  I select Do you have disability option from the dropdown
And   I select Reason option from the search box
And   I select Start Date radio button
And   I select Status radio button
And   I click on the Cancel button 
And   I see Delete Changes popup dialog
And   I click on the Discard button
And   The page is redirected to the Disability landing page


Scenario: User can continue editing, delete and save changes disability details
Given  I click on the Disability link
When   I click on the Add a Disability button
Then  I select Do you have disability option from the dropdown
And   I select Reason option from the search box
And   I select Start Date radio button
And   I select Status radio button
And   I click on the Cancel button 
And   I click on the Continue editing button
And   I click on the Review changes button
And   I click on the Save Changes button
  

 