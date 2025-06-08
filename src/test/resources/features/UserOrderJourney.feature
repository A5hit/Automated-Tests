Feature: Product Purchase Journey

  Scenario Outline: User should be able to place an order successfully
    Given Given the user's cart and saved address are empty
    Given User is on Product Page "<product_url>"
    When User adds product to cart and proceeds to checkout
    And User enters shipping details "<full_name>" "<email>" "<pincode>" "<address1>" "<address2>" "<landmark>"
    And User enters payment details
    And User places the order
    Then the confirmation message 'Order Placed Successfully' should be displayed

    Examples:
      | product_url                                                           | full_name | email         | pincode | address1        | address2  | landmark           |
      | https://dev.marche.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR | SavageAss | test@test.com | 110047  | Connaught Place | New Delhi | Near Metro Station |

  Scenario: User should be able to cancel the order successfully
    Given User is on Order Page
    When User clicks on Cancel Order
    Then Message displayed Order Cancelled Successfully



