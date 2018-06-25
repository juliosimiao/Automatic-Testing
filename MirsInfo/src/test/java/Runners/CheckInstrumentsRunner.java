package Runners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Julio on 27.6.2017.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = "C:\\Testing\\MirsInfo\\src\\test\\java\\Features",glue = {"Steps"},
        tags = "@mirsInfo")
public class CheckInstrumentsRunner {
}
