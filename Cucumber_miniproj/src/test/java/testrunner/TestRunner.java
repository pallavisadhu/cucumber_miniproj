package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="/Users/pallavisadhu/Desktop/cucumber_miniproject/Cucumber_miniproj/src/test/java/features"
		,glue={"stepdef"}
		,tags= {"@smoke"}
		,plugin={"pretty","html:target/html","json:target/report.json"}
		,monochrome=true,dryRun=false,strict=true
		)
public class TestRunner {

}
