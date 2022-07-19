package Cucumber.myTestRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Cucumber/Features"},
        glue = {"src/test/java/Cucumber/stepDefinitions"},
        dryRun = false,
        monochrome = true,
        tags = ""
        // tags = {"@SanityTest"} // Execute only Sanity Tests
        // tags = {"@SanityTest, @RegressionTest"} // Execute only scenarios which are comes under sanity OR regression
        // tags = {"@RegressionTest", "@End2End"} // Execute scenarios comes under both Regressions and End2End
        // tags = {"@SanityTest", "@End2End"} //Execute scenarios comes under both Sanity and End2End
        // tags = {"~@End2End"}   // This will ignore End2End scenarios
        // tags = {"~@End2End", "~@SanityTest"} // This will scenarios Sanity & End2End
)

public class TestRunner {

    @Before
    public void setup() {
        System.out.println("launch chrome browser");
        System.out.println("Entered URL of application");
    }

    @After
    public void tearDown() {
        System.out.println("Closed browser");
    }

}
