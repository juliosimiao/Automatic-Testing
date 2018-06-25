package Steps;

import Base.BaseUtil;
import Model.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddActivityPageObjects;
import pageObjects.MeasurementMaxPulsePageObjects;

import java.util.Set;

/**
 * Created by Julio on 19.6.2017.
 */
public class AddActivityStep {

    private BaseUtil baseUtil;
    private AddActivityPageObjects addActivityPageObjects;
    private String index = "https://www.24alife.com/home";
    private String home = "https://eu.24alife.com/group/guest/home";
    Login login;
    Set<Cookie> cookiesList;

    public AddActivityStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));

        this.addActivityPageObjects = new AddActivityPageObjects(baseUtil.driver,baseUtil.wait,
                                                                                 baseUtil.BASE_URL);

        this.login = new Login(baseUtil.driver,baseUtil.wait,baseUtil.BASE_URL);
    }

    @Given("^Open Chrome with user already in the home page$")
    public void Open_Chrome_with_user_already_in_the_home_page() throws Throwable {
        login.openPrimarySiteApplications();
        login.openTheLoginPage();
        login.logInToTheApp();
        login.clickTheLoginButton();
        /*cookiesList =  baseUtil.getDriver().manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.print(getcookies);
        }*/
    }

    @When("^Click on plus button in the right side$")
    public void Click_on_plus_button_in_the_right_side() throws Throwable {

        addActivityPageObjects.clickAddButton();
        addActivityPageObjects.clickAddActivityItem();

        /*for(Cookie getcookies :cookiesList) {
            baseUtil.getDriver().manage().addCookie(getcookies);
        }*/
    }

    @When("^Insert values from the activity$")
    public void Insert_values_from_the_activity() throws Throwable {
        addActivityPageObjects.enterValues();
    }

    @Then("^Activity should be saved$")
    public void Activity_should_be_saved() throws Throwable {
        addActivityPageObjects.clickToSaveActivity();
    }
}
