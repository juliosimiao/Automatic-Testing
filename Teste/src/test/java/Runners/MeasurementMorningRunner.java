package Runners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Julio on 15.6.2017.
 */

@RunWith(Cucumber.class)
        @Cucumber.Options(features = "C:\\Testing\\Teste\\src\\test\\java\\Features", glue = "Steps", tags = "@Measurement_Morning")
public class MeasurementMorningRunner {
}
