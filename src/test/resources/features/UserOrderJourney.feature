Feature  : User Order Journey

  Scenario: User should be able to place an order successfully
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    Then Message displayed Login Successfully
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
    When User LogIn to the Application
    And User Add Product to Cart
    And User Enter Shipping Details
    And User Enter Payment Details
    And User Place the Order
    Then Message displayed Order Placed Successfully

  Scenario: User should be able to place an order successfully
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    Then Message displayed Login Successfully
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
    When User LogIn to the Application
    And User Add Product to Cart
    And User Enter Shipping Details
    And User Enter Payment Details
    And User Place the Order
    Then Message displayed Order Placed Successfully

