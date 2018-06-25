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
import pageObjects.MeasurementMorningPageObjects;
import pageObjects.MeasurementWeightPageObjects;

/**
 * Created by Julio on 14.6.2017.
 */
public class MeasurementWeightStep {

    private BaseUtil baseUtil;
    private MeasurementWeightPageObjects measurementWeightPageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;

    public MeasurementWeightStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.measurementWeightPageObjects = new MeasurementWeightPageObjects(baseUtil.driver,baseUtil.wait,
                baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);

    }

    @Given("^OPEN Chrome and start application$")
    public void OPEN_Chrome_and_start_application() throws Throwable {
        login.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(index));
    }

    @Given("^Click On Login Button$")
    public void Click_On_Login_Button() throws Throwable {
        login.openTheLoginPage();
    }

    @When("^Choose region and enter valid username and valid password$")
    public void Choose_region_and_enter_valid_username_and_valid_password() throws Throwable {
        login.logInToTheApp();
        login.clickTheLoginButton();
    }

    @When("^Press The PLUS Button$")
    public void Press_The_PLUS_Button() throws Throwable {
        measurementWeightPageObjects.clickAddButton();
        Assert.assertTrue(baseUtil.driver.getCurrentUrl().equals(home));
    }

    @When("^Click on MEASUREMENT BUTTON$")
    public void Click_on_MEASUREMENT_BUTTON() throws Throwable {
        measurementWeightPageObjects.clickMeasurementItem();
    }

    @When("^Press WEIGHT Button$")
    public void Press_WEIGHT_Button() throws Throwable {
        measurementWeightPageObjects.clickWeightItem();
    }

    @When("^Enter values from the Weight$")
    public void Enter_values_from_the_Weight() throws Throwable {
        measurementWeightPageObjects.enterValues();
    }

    @Then("^Weight should be saved$")
    public void Weight_should_be_saved() throws Throwable {
        measurementWeightPageObjects.clickToSaveWeight();
    }


}
