package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/",
				glue = "stepdefication",
				dryRun = false,
				monochrome = true,
				plugin = {"pretty","html:test-output.html"},
				tags = "@smoke"
				)
public class TestRun {

}
