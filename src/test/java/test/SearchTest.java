package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"classpath:feature"},
        glue = "steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SearchTest extends AbstractTestNGCucumberTests {
}
