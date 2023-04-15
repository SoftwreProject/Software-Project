package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"StepDefinition"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
//        tags = "haya"d



)
public class Runclass extends AbstractTestNGCucumberTests {
}
