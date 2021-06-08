package dbs.sg.testrunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue= {"dbs.sg.step_definations"},features = "creditcards.feature",
plugin= {"pretty","html:target/cucumber-pretty"},monochrome=true)

public class creditcardcomparetestrunner
{
	
	
}
