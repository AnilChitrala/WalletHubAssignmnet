package CucumberRunner;

import Config.ExtentReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/FeatureFiles"
        ,glue={"StepDefinitions"}
)

public class TestRunner extends ExtentReport {
    ExtentReport ex=new ExtentReport();

    public void Report(){
        ExtentReport.getReportObject();
    }
}
