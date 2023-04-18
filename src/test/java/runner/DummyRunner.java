package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/FeatureUI",
        glue = {"StepDefinitions"},
        //plugin = { "pretty", "json:target/Myreports.json" },
        publish = true
)
public class DummyRunner {

}
