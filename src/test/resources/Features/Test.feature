Feature: Reset functionality on login page of Application


  Scenario Outline: Verification textBox elements
    Given Open the browser and launch the application
    When select textbox element
    And Enter the <fullName> and <email> and <currentAddress> and <permanentAddress>
    And Click in submit
    Then show data
    Examples:
    |fullName|email|currentAddress|permanentAddress|
    |kimberly|kim@gmail.com|ciudad|Guatemala|
