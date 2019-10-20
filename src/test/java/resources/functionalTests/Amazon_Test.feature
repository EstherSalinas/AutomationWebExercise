Feature: As a user I want to make a purchase in Amazon Web

Scenario Outline:1 Customer searches a product and adds it into the shopping cart

Given user is in Home Page
When he searches for "<product>"
And he adds the first item into the shopping cart
Then the "<product>" is added correctly into the shopping cart
Examples:
|product    |
|iPhone 11  |
|iPhone XR  |

