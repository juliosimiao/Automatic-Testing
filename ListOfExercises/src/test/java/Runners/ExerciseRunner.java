package Runners;

import Model.Exercise;
import cucumber.api.junit.Cucumber;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julio on 20.6.2017.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = "C:\\Testing\\ListOfExercises\\src\\test\\java\\Features",glue = {"Steps"},
        tags = "@listOfExercises")
public class ExerciseRunner {

}
