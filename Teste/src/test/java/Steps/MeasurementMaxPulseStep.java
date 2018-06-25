package Steps;

import Base.BaseUtil;
import Model.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MeasurementMaxPulsePageObjects;
import pageObjects.MeasurementMorningPageObjects;

/**
 * Created by Julio on 14.6.2017.
 */
public class MeasurementMaxPulseStep {

    private BaseUtil baseUtil;
    private MeasurementMaxPulsePageObjects measurementMaxPulsePageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;

    public MeasurementMaxPulseStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.measurementMaxPulsePageObjects = new MeasurementMaxPulsePageObjects(baseUtil.driver,baseUtil.wait,
                baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);
    }

    @Given("^Open Chrome browser and start application$")
    public void Open_Chrome_browser_and_start_application() throws Throwable {
        login.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(index));
    }

    @Given("^Click on Login button$")
    public void Click_on_Login_button() throws Throwable {
        login.openTheLoginPage();
    }

    @When("^Select Region and enter valid username and valid password$")
    public void Select_Region_and_enter_valid_username_and_valid_password() throws Throwable {
        login.logInToTheApp();
        login.clickTheLoginButton();
    }

    @When("^Press the Plus Button Button$")
    public void Press_the_Plus_Button_Button() throws Throwable {
        measurementMaxPulsePageObjects.clickAddButton();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(home));
    }

    @When("^Press Measurement Button$")
    public void Press_Measurement_Button() throws Throwable {
        measurementMaxPulsePageObjects.clickMeasurementItem();
    }

    @When("^Press Max Pulse Button$")
    public void Press_Max_Pulse_Button() throws Throwable {
        measurementMaxPulsePageObjects.clickMaxPulseItem();
    }

    @When("^Enter values from the Max Pulse$")
    public void Enter_values_from_the_Max_Pulse() throws Throwable {
        measurementMaxPulsePageObjects.enterValues();
    }

    @Then("^Max Pulse should be saved$")
    public void Max_Pulse_should_be_saved() throws Throwable {
        measurementMaxPulsePageObjects.clickToSaveMaxPulse();
    }

}
