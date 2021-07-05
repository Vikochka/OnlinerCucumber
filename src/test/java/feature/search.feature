Feature: Onliner

  Scenario Outline:Search TV
    Given Opening "https://www.onliner.by/"
    When I navigate the "Каталог" page
    And In main menu selected section "Электроника"
    And In the menu list I select "Телевидение и видео" then in the drop-down window select "Телевизоры"
    And In the Selecting by parameters part, select manufacturer:"<manufacturer>"
    And In the Selecting by parameters part, select price:"<price>"
    And In the Selecting by parameters part, select diagonal : from "<diagonalFrom>" to "<diagonalTo>"
    And In the Selecting by parameters part, select resolution:"<resolution>"
    Then Check that the search results displayed on the page are correct:"<manufacturer>","<price>","<diagonalFrom>","<diagonalTo>","<resolution>"
    Examples:
      | manufacturer | price | diagonalFrom | diagonalTo | resolution          |
      | Samsung      | 10000  | 40           | 50         | 1920x1080 (Full HD) |
