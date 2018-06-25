package pageObjects;

import Model.Instrument;
import Model.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import javax.swing.*;
import javax.xml.bind.Element;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 27.6.2017.
 */
public class CheckInstrumentsPageObjects {

    WebDriver driver;
    WebDriverWait wait;
    private String BASE_URL;
    Search search = new Search();
    ArrayList<Search> searches;
    List<WebElement> tableTRElements;
    Instrument instrument = new Instrument();
;
    By filterInstrumentUser = By.id("FilterInstrumentUser");
    By as_FilterInstrumentUser = By.id("as_FilterInstrumentUser");
    By next = By.name("Next");

    By filterVerificGroup = By.id("FilterVerificGroup");
    By as_FilterVerificGroup = By.id("as_FilterVerificGroup");

    By filterInstrumentType = By.id("FilterInstrumentType");
    By as_FilterInstrumentType = By.id("as_FilterInstrumentType");

    By fiterSerialNumber = By.name("FilterSerialNumber");

    By submitSearch = By.name("SubmitSearch");

    public CheckInstrumentsPageObjects(WebDriver driver, WebDriverWait wait, String BASE_URL) throws FileNotFoundException {
        this.driver = driver;
        this.wait = wait;
        this.BASE_URL = BASE_URL;
    }

    public void openPrimarySiteApplications(){
        StringBuilder url = new StringBuilder();
        url.append(BASE_URL);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void enterValues(File inputFile,File resultFile) throws IOException, InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(filterVerificGroup));
        searches = search.getLines(inputFile);

        if(searches!=null){
            for(int i=0;i<searches.size();i++){
                System.out.print(searches.get(i).getVerificationGroup()+"\n");
                System.out.print(searches.get(i).getCriterion()+"\n");

                wait.until(ExpectedConditions.elementToBeClickable(filterInstrumentUser));

                WebElement elementFilterInstrumentUser = driver.findElement(filterInstrumentUser);
                elementFilterInstrumentUser.clear();
                elementFilterInstrumentUser.sendKeys(searches.get(i).getUserOfTheCriterion());
                wait.until(ExpectedConditions.visibilityOfElementLocated(as_FilterInstrumentUser));
                List<WebElement> listOfFilterInstrumentUser = driver.findElements(By.xpath(".//ul[@id='as_ul']/li"));
                listOfFilterInstrumentUser.get(0).click();

                WebElement elementVerificGroup = driver.findElement(filterVerificGroup);
                elementVerificGroup.clear();
                elementVerificGroup.sendKeys(searches.get(i).getVerificationGroup());
                wait.until(ExpectedConditions.visibilityOfElementLocated(as_FilterVerificGroup));
                driver.findElement(as_FilterVerificGroup).click();

                wait.until(ExpectedConditions.elementToBeClickable(filterInstrumentType));
                WebElement elementInstrumentType = driver.findElement(filterInstrumentType);
                elementInstrumentType.clear();
                elementInstrumentType.sendKeys(searches.get(i).getCriterion());

                /*if(!(searches.get(i).getCriterion().equals("0"))){
                    wait.until(ExpectedConditions.visibilityOfElementLocated(as_FilterInstrumentType));
                    driver.findElement(as_FilterInstrumentType).click();
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(as_FilterInstrumentType));
                }*/

                wait.until(ExpectedConditions.elementToBeClickable(fiterSerialNumber));
                WebElement elementSerialNumber = driver.findElement(fiterSerialNumber);
                elementSerialNumber.clear();
                elementSerialNumber.sendKeys(searches.get(i).getFactoryNumber());

                WebElement elementSubmitSearch = driver.findElement(submitSearch);
                elementSubmitSearch.click();

                getResultAfterSearch(resultFile);
            }
        }

    }

    public void getResultAfterSearch_OLDVERSION(File resultFile) throws IOException, InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
        tableTRElements = driver.findElements(By.xpath(".//table[@class='nice']/tbody/tr"));

        while(tableTRElements.size()!=0){

            long startTime = System.currentTimeMillis();

            for(int i=0;i<tableTRElements.size();i++){
                List<WebElement> contentsOfTheTable = tableTRElements.get(i).findElements(By.tagName("td"));
                String [] contentOfTheResultTable = new String[8];
                for(int j=0;j<contentsOfTheTable.size();j++){
                    contentOfTheResultTable[j] = contentsOfTheTable.get(j).getAttribute("innerText");
                }

                Instrument currentInstrument = new Instrument(contentOfTheResultTable[0],contentOfTheResultTable[1]
                        ,contentOfTheResultTable[2],contentOfTheResultTable[3],contentOfTheResultTable[4]
                        ,contentOfTheResultTable[5],contentOfTheResultTable[6],contentOfTheResultTable[7]);

                //instrument.writeLinesOnTheFile_OLDVERSION(currentInstrument,resultFile);
            }

            long stopTime = System.currentTimeMillis();
            long elapsedTime = (stopTime - startTime) / 1000;
            System.out.println(elapsedTime);
            System.exit(0);



            WebElement elementNext = driver.findElement(next);
            elementNext.click();
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOf(elementNext));
            //wait.until(ExpectedConditions.elementToBeClickable(elementNext));
            getResultAfterSearch(resultFile);
        }
    }

    public void getResultAfterSearch(File resultFile) throws IOException, InterruptedException{
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
        }catch (TimeoutException te){
            JOptionPane.showMessageDialog(null,"An error occurred, please check your browser",
                    "Message",JOptionPane.INFORMATION_MESSAGE);

        }
        tableTRElements = driver.findElements(By.xpath(".//table[@class='nice']/tbody/tr"));

        while(tableTRElements.size()!=0){
            for(int i=0;i<tableTRElements.size();i++){
                ArrayList<Instrument> instruments = new ArrayList<>();

                List<WebElement> contentsOfTheTable = tableTRElements.get(i).findElements(By.tagName("td"));
                String [] contentOfTheResultTable = new String[8];
                for(int j=0;j<contentsOfTheTable.size();j++){
                    contentOfTheResultTable[j] = contentsOfTheTable.get(j).getAttribute("innerText");
                }

                Instrument currentInstrument = new Instrument(contentOfTheResultTable[0],contentOfTheResultTable[1]
                        ,contentOfTheResultTable[2],contentOfTheResultTable[3],contentOfTheResultTable[4]
                        ,contentOfTheResultTable[5],contentOfTheResultTable[6],contentOfTheResultTable[7]);

                instruments.add(currentInstrument);

                instrument.writeLinesOnTheFile(instruments,resultFile);
            }
            WebElement elementNext = driver.findElement(next);
            elementNext.click();
            Thread.sleep(3000);
            getResultAfterSearch(resultFile);
        }
    }
}
