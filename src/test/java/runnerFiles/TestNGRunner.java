package runnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
/*
* Reports: html, xml, json, junit, extent*/
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		monochrome = true,
		dryRun = false,
		tags = "@SearchProduct or @PlaceOrder",
		plugin = {
				"html:inbuiltReports/cucumber.html", // html report - inbuilt cucumber options
				"json:inbuiltReports/cucumber.json", // json report - inbuilt cucumber options
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: ", // extent report using aventstock and grasshopper adapter
				// file outputs = defined in "extent.properties"
				"rerun:inbuiltReports/failedScenarios.txt" // document all failed scenarios
		}
		)

public class TestNGRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
