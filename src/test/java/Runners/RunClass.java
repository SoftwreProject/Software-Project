package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"StepDefinition"},
        snippets = CucumberOptions.SnippetType.CAMELCASE



)
public class RunClass extends AbstractTestNGCucumberTests {
}
