package steps;

import framework.Browser;
import framework.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CatalogPage;
import page.MainPage;
import page.TVPage;

public class SearchTvSteps {
    protected static Browser browser = Browser.getInstance();
    MainPage mainPage;
    CatalogPage catalogPage;
    TVPage tvPage;

    @Before
    public void before() {
        browser = Browser.getInstance();
        browser.windowMaximise();
    }

    @Given("Open Onliner")
    public void openOnliner() {
        browser.navigate(PropertyReader.getProperty("URL"));
    }

    @When("Navigate Catalog page")
    public void navigatePage() {
        mainPage = new MainPage();
        mainPage.getHeader().navigatePage("Каталог");
    }

    @And("Navigate Electricity in main menu")
    public void navigateInMainMenu() {
        catalogPage = new CatalogPage("Каталог");
        catalogPage.catalogNavigation("Электроника");
    }

    @And("Navigate Television and video in menu list and TV in main dropdown list")
    public void navigateInMenuListAndInMainDropdownList() {
        catalogPage = new CatalogPage("Каталог");
        catalogPage.navigatioList("Телевидение", "Телевизоры");
    }

    @And("In the Selecting by parameters part, select manufacturer:{string}")
    public void inTheSelectingByParametersPartSelectManufacturer(String manufaturer) {
        tvPage = new TVPage("Телевизоры");
        tvPage.selectManufacturer(manufaturer);
    }

    @And("In the Selecting by parameters part, select price:{string}")
    public void inTheSelectingByParametersPartSelectPrice(String price) {
        tvPage = new TVPage("Телевизоры");
        tvPage.selectPrice(price);
    }

    @And("In the Selecting by parameters part, select resolution:{string}")
    public void inTheSelectingByParametersPartSelectResolution(String resolution) {
        tvPage = new TVPage("Телевизоры");
        tvPage.selectResolution(resolution);
    }

    @And("In the Selecting by parameters part, select diagonal : from {string} to {string}")
    public void inTheSelectingByParametersPartSelectDiagonalFromTo(String diagonalFrom, String diagonalTo) {
        tvPage = new TVPage("Телевизоры");
        tvPage.selectDiagonal(diagonalFrom, diagonalTo);
    }

    @Then("Check that the search results displayed on the page are correct:{string},{string},{string},{string},{string}")
    public void checkThatTheSearchResultsDisplayedOnThePageAreCorrect(String manufacturer, String price, String resolution, String diagonalFrom, String diagonalTo) {
        tvPage = new TVPage("Телевизоры");
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