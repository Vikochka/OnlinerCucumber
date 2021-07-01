Feature: Onliner

  Scenario Outline:Search TV
    Given Open Onliner
    When Navigate "Каталог" page
    And Navigate "Электроника" in main menu
    And Navigate "Телевидение" in menu list and "Телевизоры" in main dropdown list
    And In the Selecting by parameters part, select manufacturer:"<manufacturer>"
    And In the Selecting by parameters part, select price:"<price>"
    And In the Selecting by parameters part, select diagonal : from "<diagonalFrom>" to "<diagonalTo>"
    And In the Selecting by parameters part, select resolution:"<resolution>"
    Then Check that the search results displayed on the page are correct:"<manufacturer>","<price>","<diagonalFrom>","<diagonalTo>","<resolution>"
    Examples:
      | manufacturer | price | diagonalFrom | diagonalTo | resolution          |
      | Samsung      | 1000  | 40           | 50         | 1920x1080 (Full HD) |
