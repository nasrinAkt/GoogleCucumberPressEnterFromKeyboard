package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features = {"src/test/resources/googleFeatures"},
plugin = {"json:target/cucumber.json"},
glue = "StepDefinition")//tags = {"@tom,@tom1"})

public class runnerClass extends AbstractTestNGCucumberTests {

}
