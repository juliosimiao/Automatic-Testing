package Steps;

import Base.BaseUtil;
import Model.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MeasurementBloodPressurePageObjects;
import pageObjects.MeasurementBloodSugarPageObjects;

/**
 * Created by Julio on 14.6.2017.
 */
public class MeasurementBloodPressureStep {

    private BaseUtil baseUtil;
    private MeasurementBloodPressurePageObjects measurementBloodPressurePageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;

    public MeasurementBloodPressureStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.measurementBloodPressurePageObjects = new MeasurementBloodPressurePageObjects(baseUtil.driver,baseUtil.wait,
                baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);
    }

    @Given("^Open Chrome AND start application$")
    public void Open_Chrome_AND_start_application() throws Throwable {
        login.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(index));
    }

    @Given("^Click on LOGIN button$")
    public void Click_on_LOGIN_button() throws Throwable {
        login.openTheLoginPage();
    }

    @When("^Select region and insert valid username and valid password$")
    public void Select_region_and_insert_valid_username_and_valid_password() throws Throwable {
        login.logInToTheApp();
        login.clickTheLoginButton();
    }

    @When("^Click PLUS Button Button$")
    public void Click_PLUS_Button_Button() throws Throwable {
        measurementBloodPressurePageObjects.clickAddButton();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(home));
    }

    @When("^Click on MEASUREMENT Button$")
    public void Click_on_MEASUREMENT_Button() throws Throwable {
        measurementBloodPressurePageObjects.clickMeasurementItem();
    }

    @When("^Press BLOOD PRESSURE Button$")
    public void Press_BLOOD_PRESSURE_Button() throws Throwable {
        measurementBloodPressurePageObjects.clickBloodPressureItem();
    }

    @When("^Enter values from the Blood Pressure$")
    public void Enter_values_from_the_Blood_Pressure() throws Throwable {
        measurementBloodPressurePageObjects.enterValues();
    }

    @Then("^Blood Pressure should be saved$")
    public void Blood_Pressure_should_be_saved() throws Throwable {
        measurementBloodPressurePageObjects.clickToSaveBloodPressure();
    }

}
