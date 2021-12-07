package CucumberRunner;

import Config.ExtentReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/FeatureFiles"
        ,glue={"StepDefinitions"}
        ,plugin = {"pretty","html:src/test/Reports/CucumberReport/cucumber-report.html"}
)

public class TestRunner {

}
