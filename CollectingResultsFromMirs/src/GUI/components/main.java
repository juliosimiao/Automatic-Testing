package components;

import Model.Search;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Julio on 11.7.2017.
 */
public class main {

    public static void main(String[] args) {

        Search search = new Search();
        File file = new File("C:\\Users\\Julio\\Downloads\\Poizvedba.xlsx");
        ArrayList<Search> searches;


        long startTime = System.currentTimeMillis();
        searches = search.getLines(file);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

    }


}
