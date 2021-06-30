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

import java.util.List;

public class SearchTvSteps {
    protected static Browser browser = Browser.getInstance();

    @Before
    public void before() {
        browser = Browser.getInstance();
        browser.windowMaximise();
        //browser.navigate(PropertyReader.getProperty("URL"));
    }

    @Given("Open Onliner")
    public void openOnliner() {
        browser.navigate(PropertyReader.getProperty("URL"));
    }

    @When("Go to {string} page")
    public void goToPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigatePage("Каталог");
    }

    @And("In main menu selected {string} unit and {string}  in appeared menu")
    public void inMainMenuSelectedUnitAndInAppearedMenu() {
        CatalogPage catalogPage = new CatalogPage("Каталог");
        catalogPage.catalogNavigation("Электроника");
        catalogPage.listTitle("Телевидение и видео", "Телевизоры");
    }

    @And("In the {string} part, specify: <Specify>")
    public void inThePartSpecifySpecify() {
        TVPage tvPage = new TVPage("Телевизоры");
        tvPage.selectManufacturer("Samsung");
        tvPage.selectPrice("1000");
        tvPage.selectResolution("1920x1080 (Full HD)");
        tvPage.selectDiagonal("40", "50");
    }

    @Then("Check that the search results displayed on the page are correct")
    public void checkThatTheSearchResultsDisplayedOnThePageAreCorrect() {

    }

    @After//(alwaysRun = true, description = "Closing browser")
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }


}
