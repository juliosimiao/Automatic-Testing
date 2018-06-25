package Model;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Julio on 27.6.2017.
 */
public class Instrument {

    private String owner; //imetnik
    private String criterion; //merilo
    private String factoryNumber; //Tovarniška številka
    private String typeApprovalMark; //Oznaka odobritve tipa
    private String inComposition; //V sestavi
    private String dateAndTypeOfVerification; //Datum in vrsta overitve
    private String validityOfTheVerification; //Veljavnost overitve
    private String verificationGroup; //Overitvena skupina
    public String PathToTheResultFile = "C:\\Testing\\MirsInfo\\src\\test\\resources\\result_values.xlsx";

    public Instrument(String owner,String criterion,String factoryNumber,String typeApprovalMark,String inComposition,
        String dateAndTypeOfVerification,String validityOfTheVerification,String verificationGroup){
        this.owner = owner;
        this.criterion = criterion;
        this.factoryNumber = factoryNumber;
        this.typeApprovalMark = typeApprovalMark;
        this.inComposition = inComposition;
        this.dateAndTypeOfVerification = dateAndTypeOfVerification;
        this.validityOfTheVerification = validityOfTheVerification;
        this.verificationGroup = verificationGroup;
    }

    public Instrument(){}

    public void writeLabelsOnTheFile() throws FileNotFoundException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Results");
        XSSFRow row;
        Map< String, Object[] > empinfo = new TreeMap< String, Object[] >();

            empinfo.put( "1", new Object[] {
            "Imetnik (uporabnik)", "Merilo", "Tovarniška številka","Oznaka odobritve tipa","V sestavi"
                    ,"Datum in vrsta overitve","Veljavnost overitve","Overitvena skupina"
        });

        Set< String > keyid = empinfo.keySet();
        int rowid = 0;

            for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

            try {
            FileOutputStream out = new FileOutputStream(
                    new File(PathToTheResultFile));
            workbook.write(out);
            out.close();
        }catch (IOException e){

        }
    }
    public void writeLinesOnTheFile(Instrument currentInstrument) throws IOException {
        try {

            FileInputStream file = new FileInputStream(new File(PathToTheResultFile));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowOfTheFile = sheet.getPhysicalNumberOfRows();
            Cell cell = null;

            Row row = sheet.createRow(lastRowOfTheFile);
            row.createCell(0).setCellValue(currentInstrument.getOwner());
            row.createCell(1).setCellValue(currentInstrument.getCriterion());
            row.createCell(2).setCellValue(currentInstrument.getFactoryNumber());
            row.createCell(3).setCellValue(currentInstrument.getTypeApprovalMark());
            row.createCell(4).setCellValue(currentInstrument.getInComposition());
            row.createCell(5).setCellValue(currentInstrument.getDateAndTypeOfVerification());
            row.createCell(6).setCellValue(currentInstrument.getValidityOfTheVerification());
            row.createCell(7).setCellValue(currentInstrument.getVerificationGroup());

            FileOutputStream outFile =new FileOutputStream(new File(PathToTheResultFile));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String toString(){
        return getOwner()+"\n"+getCriterion()+"\n"+getFactoryNumber()+"\n"+getTypeApprovalMark()
                +"\n"+getInComposition()+"\n"+getDateAndTypeOfVerification()
                +"\n"+getValidityOfTheVerification()+"\n"+getVerificationGroup();
    }

    public String getOwner() {
        return owner;
    }

    public String getCriterion() {
        return criterion;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public String getTypeApprovalMark() {
        return typeApprovalMark;
    }

    public String getInComposition() {
        return inComposition;
    }

    public String getDateAndTypeOfVerification() {
        return dateAndTypeOfVerification;
    }

    public String getValidityOfTheVerification() {
        return validityOfTheVerification;
    }

    public String getVerificationGroup() {
        return verificationGroup;
    }
}
