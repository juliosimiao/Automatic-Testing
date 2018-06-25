package Runners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Julio on 14.6.2017.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = "C:\\Testing\\Teste\\src\\test\\java\\Features",glue = {"Steps"},
        tags = "@Measurement_Max_Pulse")
public class MeasurementMaxPulseRunner {
}
