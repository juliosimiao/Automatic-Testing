package Model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julio on 20.6.2017.
 */
public class Exercise {

    private String exerciseName;
    private String blankLabel;
    private String initialPosition;
    private String execution;
    private String watch;
    private String commonMistakes;
    String aux[];

    public Exercise(String exerciseName,String initialPosition, String execution,
                    String watch, String commonMistakes){
        this.exerciseName = exerciseName;
        this.initialPosition = initialPosition;
        this.execution = execution;
        this.watch = watch;
        this.commonMistakes = commonMistakes;
    }

    public Exercise(){}

    public String getExerciseName() {
        return exerciseName;
    }
    public String getInitialPosition() {
        return initialPosition;
    }
    public String getExecution() {
        return execution;
    }
    public String getWatch() { return watch; }
    public String getCommonMistakes() {
        return commonMistakes;
    }

    public ArrayList<Exercise> getLines_OLD_VERSION(String path,int initialRow,int lastRow,int initialCell,int lastCell){

        ArrayList<Exercise> exercises = new ArrayList<>();
        File inputFile = new File(path);
        Workbook w;

        try {
            w = new XSSFWorkbook(inputFile);
            Sheet sheet = w.getSheetAt(1);

            for(int i=initialRow-1;i<lastRow;i++){
                aux = new String[lastCell-initialCell];
                int k = 0;
                for(int j=initialCell;j<lastCell;j++){
                    Cell cell = sheet.getRow(i).getCell(j);
                    aux[k] = cell.getStringCellValue();System.out.print("celula: ("+(i+1)+","+j+") = "+aux[k]+"\n");
                    k++;
                }

                System.out.print("\n");
                exerciseName = aux[0];
                blankLabel= aux[1];
                initialPosition= aux[2];
                execution= aux[3];
                watch= aux[4];
                commonMistakes= aux[5];
                exercises.add(new Exercise(exerciseName,initialPosition,execution,watch,commonMistakes));
            }

            return exercises;

        }catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Exercise> getLines(String path,int initialRow,int lastRow,int initialCell,int lastCell){

        ArrayList<Exercise> exercises = new ArrayList<>();
        File inputFile = new File(path);
        Workbook w;

        try {
            w = new XSSFWorkbook(inputFile);
            Sheet sheet = w.getSheetAt(1);

            for(int i=initialRow-1;i<lastRow;i++){
                aux = new String[lastCell-initialCell];
                int k = 0;
                Row row = sheet.getRow(i);
                if(row.getZeroHeight()==false){ //Jump the hidden cells
                    for(int j=initialCell;j<lastCell;j++){
                        Cell cell = sheet.getRow(i).getCell(j);
                        aux[k] = cell.getStringCellValue();
                        k++;
                    }
                    System.out.print("\n");
                    exerciseName = aux[0];
                    blankLabel= aux[1];
                    initialPosition= aux[2];
                    execution= aux[3];
                    watch= aux[4];
                    commonMistakes= aux[5];
                    exercises.add(new Exercise(exerciseName,initialPosition,execution,watch,commonMistakes));
                }
            }

            return exercises;

        }catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }
}
