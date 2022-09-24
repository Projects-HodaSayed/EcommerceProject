@smoke
Feature: Testing home slider is opening the right page
  Scenario:  first slider is clickable on home page
    Given user open the home page
    When User click the first slider
    Then Nokia page url is opened

  Scenario:  second slider is clickable on home page
    Given user open the home page
    When User click the second slider
    Then Iphone page url is opened
