package TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"capstome.feature"}, glue = "StepDefinition", plugin = {"html:target/test-report.html"}, monochrome = true)
@Test
public class TestRunner{

}