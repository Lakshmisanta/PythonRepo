Feature: My Time Off page functionality

Background: I am login and navigate to my details page
Given login application URL
Then Navigate to myTimeOff page

@End2EndTest
Scenario: My TimeOff leaves applied and pending functionality

Given Starting TestCase "Basic Details Edit functionality"
And Get pending annual leaves
And Get the leaves taken
And Ending Test case


