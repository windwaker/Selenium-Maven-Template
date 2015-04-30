Feature: Customer Balance

    Verifying a customer's data should be quick and easy.

    Scenario: I want to verify I am on the tables page

        Given I have logged into the application
        When I navigate to the tables page
        Then the page should have a title of 'the-internet'
        And the page should contain the text 'Really Important Stuff'

    Scenario: Customers over $500

        There should be three users with a balance of over $500

        Given I have logged into the application
        When I navigate to the tables page
        Then I should see three customers with over $500

    Scenario: Customer surnames

        There should be three users with a surname of 'Harrington'

        Given I have logged into the application
        When I navigate to the tables page
        Then I should see three customers with the surname 'Harrington'

    Scenario: Registered users

        There should be four registered users on the page

        Given I have logged into the application
        When I navigate to the tables page
        Then I should see four registered users

    Scenario: Default sort order




