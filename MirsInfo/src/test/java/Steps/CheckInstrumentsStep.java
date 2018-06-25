package Steps;

import Base.BaseUtil;
import Model.Instrument;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CheckInstrumentsPageObjects;

import java.io.FileNotFoundException;

/**
 * Created by Julio on 27.6.2017.
 */
public class CheckInstrumentsStep {

    private BaseUtil baseUtil;
    private CheckInstrumentsPageObjects checkInstrumentsPageObjects;
    private String index = "http://www.mirs-info.si/Verification/index.php?Action=CheckInstrument";
    private String inputFile = "C:\\Testing\\MirsInfo\\src\\test\\resources\\Poizvedba.xlsx";
    //private String inputFile = "C:\\Users\\Julio\\Downloads\\arquivo_downloads2.xlsx";
    private Instrument instrument = new Instrument();

    public CheckInstrumentsStep() throws FileNotFoundException {
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));
        baseUtil.setBASE_URL(index);
        this.checkInstrumentsPageObjects = new CheckInstrumentsPageObjects(baseUtil.getDriver(), baseUtil.getWait(),
                baseUtil.getBASE_URL());
    }

    @Given("^Open Chrome Browser and start application$")
    public void Open_Chrome_Browser_and_start_application() throws Throwable {
        checkInstrumentsPageObjects.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.getDriver().getCurrentUrl().equals(index));
    }

    @Given("^Enter input values$")
    public void Enter_input_values() throws Throwable {
        instrument.writeLabelsOnTheFile();
        checkInstrumentsPageObjects.enterValues(inputFile);
    }

    @Then("^Get the results and store$")
    public void Get_the_results_and_store() throws Throwable {
        //checkInstrumentsPageObjects.getResultAfterSearch();
    }

}
