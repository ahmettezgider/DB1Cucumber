package orangehrm;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/com/guidersoft/controlBased/features"},
        glue = {"com/guidersoft/controlBased/steps"},
        plugin = {"pretty"}

)
public class HRMRunnerTest1 {
}
