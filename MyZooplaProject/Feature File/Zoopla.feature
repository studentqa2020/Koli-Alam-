Feature: Zoopla Automation

Scenario: Zoopla Automation End to End
Given User is on Zoopla Website
When  User click on Signin Buton
And  User Enters Credentials and Submit Login
Then User is on Search Property page
When User Enters City Name and Search Properties
Then User gets the Properties page
When User Display all Properties prices in desc order
And User Selects Fifth Property
And User Verify Logo
And  User Display Agent name and Phone Num
And User clicks on Sign out button
Then User Signs Out