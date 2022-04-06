Feature: Reset functionality on login page of Application


  Scenario Outline: Verification textBox elements
    Given Open the browser and launch the application
    When search <word>
    And click <result>
    And searching in wikipedia <wikipediaWord>
    And select <externalLink>
    Then show data
    Examples:
    |word|result|wikipediaWord|externalLink|
    |wikipedia.com|https://www.wikipedia.com/|Selenium|https://www.tutorialdeprogramacion.com/2019/08/tutorial-python-con-selenium.html|
