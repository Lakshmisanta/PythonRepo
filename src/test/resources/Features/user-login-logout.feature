Feature: Login and logout Functionality


Scenario Outline: Login and logout inside UCL application

  Given I navigate to Inside UCL app <URL>
  And I should see login page
  When I enter <Username> and <Password>
  And I click on login
  Then I should see application home page
  And I logout from application
  Then I should be on login page

Examples:
  | URL                                      | Username          | Password        |
  | https://app-uat.ucl.ac.uk/InsideUCL/Home | ccaessw@ucl.ac.uk | BenNevis!234567 |
