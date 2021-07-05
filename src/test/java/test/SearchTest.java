package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/feature/search.feature"},
        glue = "steps",
        plugin = {"pretty","html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class SearchTest extends AbstractTestNGCucumberTests {
}
