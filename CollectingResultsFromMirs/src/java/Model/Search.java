package Model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Julio on 27.6.2017.
 */
public class Search {

    private String userOfTheCriterion; //Uporabnik merila
    private String verificationGroup; //Overitvena skupina *
    private String criterion; //Merilo *
    private String factoryNumber; //Tovarniška številka *
    //private String inComposition; //V sestavi

    public Search(String userOfTheCriterion,String verificationGroup,String criterion,String factoryNumber) {
        this.userOfTheCriterion = userOfTheCriterion;
        this.verificationGroup = verificationGroup;
        this.criterion = criterion;
        this.factoryNumber = factoryNumber;
        //this.inComposition = inComposition;
    }

    public Search(){}

    public ArrayList<Search> getLines_OLDVERSION(String path){

        ArrayList<Search> searches = new ArrayList<>();
        File inputFile = new File(path);
        Workbook w;

        try {
            w = new XSSFWorkbook(inputFile);
            Sheet sheet = w.getSheetAt(0);

            for(int i=1;i<2;i++){
                String[] aux = new String[5];
                int k = 0;
                Row row = sheet.getRow(i);
                if(row.getZeroHeight()==false){ //Jump the hidden cells
                    for(int j=0;j<5;j++){
                        if(j==3){
                            Cell cell = sheet.getRow(i).getCell(j);
                            aux[k] =  (int) cell.getNumericCellValue() + "";
                            k++;
                        }else{
                            Cell cell = sheet.getRow(i).getCell(j);
                            aux[k] = cell.getStringCellValue();
                            k++;
                        }
                    }
                    System.out.print("\n");
                    //userOfTheCriterion = aux[0];
                    verificationGroup= aux[1];
                    criterion= aux[2];
                    factoryNumber= aux[3];
                    //inComposition= aux[4];
                    //searches.add(new Search(userOfTheCriterion,verificationGroup,criterion,factoryNumber,inComposition));
                }
             }

             return searches;

        }catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Search> getLines(File file){

        try {

            ArrayList<Search> searches = new ArrayList<>();
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            String[] contentOfTheCellInAnRow = new String[4];
            //int i=0;

            while (iterator.hasNext()) {
            //while (i<2) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                int j=0;

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        contentOfTheCellInAnRow[j] = currentCell.getStringCellValue();
                    }else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        contentOfTheCellInAnRow[j] = (int) currentCell.getNumericCellValue() + "";
                    }
                    j++;
                }//i++;

                userOfTheCriterion = contentOfTheCellInAnRow[0];
                verificationGroup = contentOfTheCellInAnRow[1];
                criterion = contentOfTheCellInAnRow[2];
                factoryNumber = contentOfTheCellInAnRow[3];

                searches.add(new Search(userOfTheCriterion,verificationGroup,criterion,factoryNumber));
            }

            excelFile.close();
            return searches;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getUserOfTheCriterion() {return userOfTheCriterion; }

    public String getVerificationGroup() {
        return verificationGroup;
    }

    public String getCriterion() {
        return criterion;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

}
