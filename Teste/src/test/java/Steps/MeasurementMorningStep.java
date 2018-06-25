package Steps;

import Base.BaseUtil;
import Model.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MeasurementMorningPageObjects;

/**
 * Created by Julio on 15.6.2017.
 */
public class MeasurementMorningStep extends Login{

    private BaseUtil baseUtil;
    private MeasurementMorningPageObjects measurementMorningPageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;

    public MeasurementMorningStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.measurementMorningPageObjects = new MeasurementMorningPageObjects(baseUtil.driver,baseUtil.wait,
                baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);
    }

    @Given("^Open Chrome and start application$")
    public void Open_Chrome_and_start_application() throws Throwable {
        login.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(index));
    }

    @Given("^Click on login button$")
    public void Click_on_login_button() throws Throwable {
        login.openTheLoginPage();
    }

    @When("^Select region and enter valid username and valid password$")
    public void Select_region_and_enter_valid_username_and_valid_password() throws Throwable {
        login.logInToTheApp();
        login.clickTheLoginButton();
    }

    @When("^Press the PLUS Button Button$")
    public void Press_the_PLUS_Button_Button() throws Throwable {
        measurementMorningPageObjects.clickAddButton();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(home));
    }

    @When("^Press MEASUREMENT Button$")
    public void Press_MEASUREMENT_Button() throws Throwable {
        measurementMorningPageObjects.clickMeasurementItem();
    }

    @When("^Press Morning Measurement Button$")
    public void Press_Morning_Measurement_Button() throws Throwable {
        measurementMorningPageObjects.clickMorningMeasurementItem();
    }

    @When("^Enter values from the Morning Measurement$")
    public void Enter_values_from_the_Morning_Measurement() throws Throwable {
        measurementMorningPageObjects.enterValues();
    }

    @Then("^Morning Measurement should be saved$")
    public void Morning_Measurement_should_be_saved() throws Throwable {
        measurementMorningPageObjects.clickToSaveMorningMeasurement();
        //measurementMorningPageObjects.getDriver().close(); //CLOSE THE BROWSER
    }
}
