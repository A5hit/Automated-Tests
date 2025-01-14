Feature  : Product Purchase Journey

  Scenario Outline : User should be able to place an order successfully
    Given User is on Product Page <product_url>
    When User Add Product to Cart and Proceed to Checkout
    And User Enter Shipping Details
    And User Enter Payment Details
    And User Place the Order
    Then Message displayed Order Placed Successfully
    Examples:
      | Product                                                                 |
      | "https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR" |


  Scenario: User should be able to cancel the order successfully
    Given User is on Order Page
    When User Click on Cancel Order
    Then Message displayed Order Cancelled Successfully
