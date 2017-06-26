Feature: Locations search
  Scenario Outline: user can search for Locations

    Given user is on Locations page
    When  user searches for a location using <zipCode> zip code
    Then  message matches with <expectedMessage>
    And   Check Pricing button should be displayed: <pricingButtonDisplayed>

    Examples: Zip code | Pricing button | Expected message
    | zipCode | pricingButtonDisplayed  | expectedMessage                         |
    | 90028   | true                    | WE'VE GOT YOU COVERED!                  |
    | 11192   | false                   | SORRY! YOU'RE OUTSIDE OUR SERVICE AREA  |
#    | 99999   | true                    | TEST SHOULD FAIL                        |