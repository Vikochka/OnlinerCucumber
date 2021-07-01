package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/feature/search.feature"},
        glue = "steps",
        plugin = {"pretty"}
)
public class SearchTest extends AbstractTestNGCucumberTests {
}
