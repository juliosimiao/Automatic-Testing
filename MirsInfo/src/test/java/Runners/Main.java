package Runners;

import Model.Instrument;
import Model.Search;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Julio on 27.6.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Search search = new Search();
        ArrayList<Search> searches;

        /*searches = search.getLines("C:\\Testing\\MirsInfo\\src\\test\\resources\\Poizvedba.xlsx");

        for(int i=0;i<searches.size();i++){
            System.out.print(searches.get(i).getVerificationGroup()+"\n");
        }*/

        Instrument instrument = new Instrument();
        instrument.writeLabelsOnTheFile();
        Instrument currentInstrument = new Instrument("c","b","23"
                ,"g","e","f","g"
                ,"i");

        InputStream myxls = new FileInputStream("C:\\Users\\Julio\\Desktop\\teste.xlsx");
        Workbook book = new XSSFWorkbook(myxls);
        Sheet sheet = book.getSheetAt(0);
        int lastRowOfTheFile = sheet.getPhysicalNumberOfRows(); System.out.print("ultima row "+lastRowOfTheFile);

        instrument.writeLinesOnTheFile(currentInstrument);
    }
}
