Feature: Onliner

  Scenario:Search TV
    Given Open Onliner
    When Go to "Каталог" page
      | pageTitle | Каталог |
    And In main menu selected "Электроника" unit and "Телевидение и видео"  in appeared menu
      | menuSection | Электроника         |
      | menuSection | Телевидение и видео |
      | menuSection | Телевизоры          |
    And In the "Selecting by parameters" part, specify: <Specify>
    Then Check that the search results displayed on the page are correct