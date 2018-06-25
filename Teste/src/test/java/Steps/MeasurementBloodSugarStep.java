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
import pageObjects.MeasurementBloodSugarPageObjects;
import pageObjects.MeasurementMaxPulsePageObjects;

/**
 * Created by Julio on 14.6.2017.
 */
public class MeasurementBloodSugarStep {

    private BaseUtil baseUtil;
    private MeasurementBloodSugarPageObjects measurementBloodSugarPageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;

    public MeasurementBloodSugarStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.measurementBloodSugarPageObjects = new MeasurementBloodSugarPageObjects(baseUtil.driver,baseUtil.wait,
                baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);
    }

    @Given("^Open CHROME and start application$")
    public void Open_CHROME_and_start_application() throws Throwable {
        login.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(index));
    }

    @Given("^Click on login Button$")
    public void Click_on_login_Button() throws Throwable {
        login.openTheLoginPage();
    }

    @When("^Select region and Enter valid username and valid password$")
    public void Select_region_and_Enter_valid_username_and_valid_password() throws Throwable {
        login.logInToTheApp();
        login.clickTheLoginButton();
    }

    @When("^Press the PLUS BUTTON$")
    public void Press_the_PLUS_BUTTON() throws Throwable {
        measurementBloodSugarPageObjects.clickAddButton();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(home));
    }

    @When("^Press MEASUREMENT BUTTON$")
    public void Press_MEASUREMENT_BUTTON() throws Throwable {
        measurementBloodSugarPageObjects.clickMeasurementItem();
    }

    @When("^Press BLOOD SUGAR Button$")
    public void Press_BLOOD_SUGAR_Button() throws Throwable {
        measurementBloodSugarPageObjects.clickBloodSugarItem();
    }

    @When("^Enter values from the Blood Sugar$")
    public void Enter_values_from_the_Blood_Sugar() throws Throwable {
        measurementBloodSugarPageObjects.enterValues();
    }

    @Then("^Blood Sugar should be saved$")
    public void Blood_Sugar_should_be_saved() throws Throwable {
        measurementBloodSugarPageObjects.clickToSaveBloodSugar();
    }
}
