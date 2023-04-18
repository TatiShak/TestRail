package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/FeatureAPI",
        glue = {"StepDefinitions"},
        //plugin = { "pretty", "json:target/Myreports.json" },
        monochrome=true,
        publish = true
)
    public class APIRunner {
    }
