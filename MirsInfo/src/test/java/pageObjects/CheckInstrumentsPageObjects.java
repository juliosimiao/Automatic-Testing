package pageObjects;

import Model.Instrument;
import Model.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import javax.xml.bind.Element;
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
    ArrayList<Instrument> instruments = new ArrayList<>();;
    List<WebElement> tableTRElements;
    Instrument instrument = new Instrument();

    //By allCompanyUnits = By.name("AllCompanyUnits");
    //By filterInstrumentUser = By.id("FilterInstrumentUser");
    //By filterIsPartOf = By.id("FilterIsPartOf");
    //By next = By.name("Next");

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

    public void enterValues(String file) throws IOException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(filterVerificGroup));
        searches = search.getLines(file);

        if(searches!=null){
            for(int i=0;i<searches.size();i++){

                wait.until(ExpectedConditions.elementToBeClickable(filterVerificGroup));

                WebElement elementVerificGroup = driver.findElement(filterVerificGroup);
                elementVerificGroup.clear();
                elementVerificGroup.sendKeys(searches.get(i).getVerificationGroup());
                wait.until(ExpectedConditions.visibilityOfElementLocated(as_FilterVerificGroup));
                driver.findElement(as_FilterVerificGroup).click();

                wait.until(ExpectedConditions.elementToBeClickable(filterInstrumentType));

                WebElement elementInstrumentType = driver.findElement(filterInstrumentType);
                elementInstrumentType.clear();
                elementInstrumentType.sendKeys(searches.get(i).getCriterion());

                if(!(searches.get(i).getCriterion().equals("0"))){
                    wait.until(ExpectedConditions.visibilityOfElementLocated(as_FilterInstrumentType));
                    driver.findElement(as_FilterInstrumentType).click();
                }

                wait.until(ExpectedConditions.elementToBeClickable(fiterSerialNumber));

                WebElement elementSerialNumber = driver.findElement(fiterSerialNumber);
                elementSerialNumber.clear();
                elementSerialNumber.sendKeys(searches.get(i).getFactoryNumber());

                WebElement elementSubmitSearch = driver.findElement(submitSearch);
                elementSubmitSearch.click();

                getResultAfterSearch();
            }
        }

    }

    public void getResultAfterSearch() throws IOException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
        tableTRElements = driver.findElements(By.xpath(".//table[@class='nice']/tbody/tr"));

        for(int i=0;i<tableTRElements.size();i++){
            List<WebElement> contentsOfTheTable = tableTRElements.get(i).findElements(By.tagName("td"));
            String [] contentOfTheResultTable = new String[8];
            for(int j=0;j<contentsOfTheTable.size();j++){
                contentOfTheResultTable[j] = contentsOfTheTable.get(j).getAttribute("innerText");
            }

            Instrument currentInstrument = new Instrument(contentOfTheResultTable[0],contentOfTheResultTable[1]
                    ,contentOfTheResultTable[2],contentOfTheResultTable[3],contentOfTheResultTable[4]
                    ,contentOfTheResultTable[5],contentOfTheResultTable[6],contentOfTheResultTable[7]);

            instrument.writeLinesOnTheFile(currentInstrument);
        }
    }
}
