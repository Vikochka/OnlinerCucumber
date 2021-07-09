package onliner.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/onliner/pageObject/feature/search.feature"},
        glue = "onliner/steps",
        plugin = {"pretty","html:target/cucumber.html",
                "json:target/cucumber.json","json:target/cucumber-reports/CucumberTestReport.json"}
)
public class SearchTest extends AbstractTestNGCucumberTests {
}
