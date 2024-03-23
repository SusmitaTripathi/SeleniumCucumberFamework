package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import utils.GenericUtils;
import utils.TestContextSetup;

public class Hooks {

    public TestContextSetup testContextSetup;
    GenericUtils genericUtils;

    //dependency injection to access WebDriverManager() to get driver instance
    public Hooks(TestContextSetup testContextSetup){

        this.testContextSetup = testContextSetup;
        this.genericUtils = testContextSetup.genericUtils;
    }

    @AfterStep
    public void addScrenshotOnFailure(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            genericUtils.addScreenshotToReport(scenario);
        }
    }

    //Cucumber hook to be executed at the end of each scenario
    @After
    public void afterScenario() throws Exception {
        testContextSetup.testBase.WebDriverManager().quit();
    }
}
