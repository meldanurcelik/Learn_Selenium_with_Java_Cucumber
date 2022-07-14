package Cucumber.day31.myTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Cucumber/day31/Features/MyAccount-Login.feature",
        glue = "src/test/java/Cucumber/day31/stepDefinitions/MyAccountLoginStepDefinitions.java"
)

public class TestRunner {

}
