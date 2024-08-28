package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features/placeValidation.feature",
    glue = {"stepDefinations"}, plugin={"pretty"}, tags="@DeletePlace")
public class TestRunner {

}
