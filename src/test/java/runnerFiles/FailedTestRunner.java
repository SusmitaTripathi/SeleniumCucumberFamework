package runnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/*
* Reports: html, xml, json, junit, extent*/
@CucumberOptions(
		features = "@inbuiltReports\\failedScenarios.txt",
		glue = "stepDefinitions",
		monochrome = true,
		plugin = {
				"html:inbuiltReports/cucumber.html", // html report - inbuilt cucumber options
				"json:inbuiltReports/cucumber.json", // json report - inbuilt cucumber options
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: " // extent report using aventstock and grasshopper adapter
				// file outputs = defined in "extent.properties"
		}
		)

public class FailedTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
