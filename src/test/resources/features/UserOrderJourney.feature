Feature  : Product Purchase Journey

  Background:
    User have blank cart & blank Address

  Scenario Outline : User should be able to place an order successfully
    Given User is on Product Page <product_url>
    When User Add Product to Cart and Proceed to Checkout
    And User Enter Shipping Details <"full_name"> <"email"> <"pincode"> <"address1"> <"address2"> <"landmark">
    And User Enter Payment Details
    And User Place the Order
    Then Message displayed Order Placed Successfully
    Examples:
      | Product                                                                 | full_name   | email             | pincode | address1          | address2    | landmark             |
      | "https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR" | "SavageAss" | " test@test.com " | 110047  | "Connaught Place" | "New Delhi" | "Near Metro Station" |


  Scenario: User should be able to cancel the order successfully
    Given User is on Order Page
    When User Click on Cancel Order
    Then Message displayed Order Cancelled Successfully
