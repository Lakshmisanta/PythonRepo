Feature: Login and logout Functionality

@RegressionTest
Scenario Outline: Login and logout Inside UCL application

Given I should navigate to Inside UCL app <URL>
And I should see login page
When I enter <Username> and <Password>  
And I Click on Login button
Then I should see application home page
When I click on popup menu  
And I Click on Logout button
Then I should see Welcome to Inside UCL

Examples:
| URL | Username | Password |
| https://app-uat.ucl.ac.uk/InsideUCL/Home | ccaessw@ucl.ac.uk | BenNevis!234567 |