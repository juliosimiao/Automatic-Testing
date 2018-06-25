package Runners;

import Model.Exercise;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by Julio on 21.6.2017.
 */
public class Main {

    public static void main(String[] args){

        String file = "C:\\Testing\\ListOfExercises\\src\\test\\resources\\KopijaVaje_Baza_POPRAVEK.xlsx";
        int initialRow = 84;
        int lastRow = 85;
        int initialCell = 17;
        int lastCell = 23;
        ArrayList<Exercise> exercises;
        Exercise exercise = new Exercise();

        //Assert.assertEquals(true, "teste".equals("ola") || "teste".equals("teste"));

        /*exercises = exercise.getLines(file,initialRow,lastRow,initialCell,lastCell);

        for(int i=0;i<exercises.size();i++){
            System.out.print(exercises.get(i).getExerciseName()+"\n");
        }*/




    }
}
