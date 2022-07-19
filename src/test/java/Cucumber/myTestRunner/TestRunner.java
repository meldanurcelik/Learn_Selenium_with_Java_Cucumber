package Cucumber.myTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Cucumber/Features"},
        glue = {"src/test/java/Cucumber/stepDefinitions"},
        dryRun = false,
        monochrome = true,
        tags = "@melda"
)

public class TestRunner {

}
