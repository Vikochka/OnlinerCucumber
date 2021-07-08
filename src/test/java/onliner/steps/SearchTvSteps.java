package onliner.steps;

import framework.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObject.page.CatalogPage;
import onliner.pageObject.page.MainPage;
import onliner.pageObject.page.TVPage;

public class SearchTvSteps {
    protected static Browser browser = Browser.getInstance();
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage("Каталог");
    TVPage tvPage = new TVPage("Телевизоры");

    @Before
    public void before() {
        browser = Browser.getInstance();
        browser.windowMaximise();
    }

    @Given("Opening {string}")
    public void opening(String url) {
        browser.navigate(url);
    }

    @When("I navigate the {string} page")
    public void navigatePage(String title) {
        mainPage.getMainMenu().navigatePage(title);
    }

    @And("In main menu selected section {string}")
    public void navigateInMainMenu(String electronics) {
        catalogPage.navigateCatalog(electronics);
    }

    @And("In the menu list I select {string} then in the drop-down window select {string}")
    public void navigateInMenuListAndInMainDropdownList(String tvAndVideo,String tv) {
        catalogPage.navigateList(tvAndVideo, tv);
    }

    @And("In the Selecting by parameters part, select manufacturer:{string}")
    public void inTheSelectingByParametersPartSelectManufacturer(String manufaturer) {
        tvPage.selectManufacturer(manufaturer);
    }

    @And("In the Selecting by parameters part, select price:{string}")
    public void inTheSelectingByParametersPartSelectPrice(String price) {
        tvPage.selectPrice(price);
    }

    @And("In the Selecting by parameters part, select resolution:{string}")
    public void inTheSelectingByParametersPartSelectResolution(String resolution) {
        tvPage.selectResolution(resolution);
    }

    @And("In the Selecting by parameters part, select diagonal : from {string} to {string}")
    public void inTheSelectingByParametersPartSelectDiagonalFromTo(String diagonalFrom, String diagonalTo) {
        tvPage.selectDiagonal(diagonalFrom, diagonalTo);
    }

    @Then("Check that the search results displayed on the page are correct:{string},{string},{string},{string},{string}")
    public void checkThatTheSearchResultsDisplayedOnThePageAreCorrect(String manufacturer, String price, String resolution, String diagonalFrom, String diagonalTo) {
        tvPage.validationManufacturer(manufacturer);
        tvPage.validationPrice(price);
        tvPage.validationResolution(resolution);
        tvPage.validationDiagonal(diagonalFrom, diagonalTo);
    }

    @After
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }


}