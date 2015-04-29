Feature: Customer Balance

    Verifying a customer's data should be quick and friendly.

    Scenario: ?

        New users should get a confirmation email and be greeted
        personally by the site once signed in.

        Given I have chosen to sign up
        When I sign up with valid details
        Then I should receive a confirmation email
        And I should see a personalized greeting message

    Scenario: ?

        Where someone tries to create an account for an email address
        that already exists.

        Given I have chosen to sign up
        When I sign up with an email address that has already registered Then I should be told that the email is already registered
        And I should be offered the option to recover my password