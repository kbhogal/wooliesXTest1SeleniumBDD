package RunTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/main/resources/features/feature2.feature"},
		glue= {"StepDefinitions" }
		

		)


public class AllTests {

}
