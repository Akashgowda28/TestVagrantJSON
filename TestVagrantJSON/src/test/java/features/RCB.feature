
Feature: Validating  RCB Team Info

Scenario: Validating Team Has only 4 foreign Players

Given Get The Json Of The Team
When Validate the Number of Foreign Players
Then Validation Is SuccessFull



Scenario: Validating Team Atleast one wicket Keeper

Given Get The Json Of The Team
When Validate the Atleast one wicket Keeper is present
Then Validation Is SuccessFull