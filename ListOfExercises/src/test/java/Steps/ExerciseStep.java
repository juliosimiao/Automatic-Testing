package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ExercisePageObjects;
import pageObjects.LoginPageObjects;

/**
 * Created by Julio on 20.6.2017.
 */
public class ExerciseStep {

    private BaseUtil baseUtil;
    private ExercisePageObjects exercisePageObjects;
    private String index = "http://test.a-life.si/web/fitnesstrainer";
    private String home = "http://test.a-life.si/group/fitnessTrainer?get_trainer_users/get_trainer_users";
    private String exerciseHome = "http://test.a-life.si/group/fitnessTrainer?list_of_exercises_only/list_of_exercises_only";
    LoginPageObjects loginPageObjects;

    String file = "C:\\Testing\\ListOfExercises\\src\\test\\resources\\KopijaVaje_Baza_POPRAVEK.xlsx";
    int initialRow = 2;
    int lastRow = 137;
    int initialCell = 17;
    int lastCell = 23;

    public ExerciseStep(){
        this.baseUtil = new BaseUtil();
        baseUtil.setDriver(new ChromeDriver());
        baseUtil.setBASE_URL(index);
        baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),70));

        this.exercisePageObjects = new ExercisePageObjects(baseUtil.getDriver(),baseUtil.getWait(),
                baseUtil.getBASE_URL());

        this.loginPageObjects = new LoginPageObjects(baseUtil.getDriver(),baseUtil.getWait(),
                baseUtil.getBASE_URL());
    }


    @Given("^Open Chrome Browser and start application$")
    public void Open_Chrome_Browser_and_start_application() throws Throwable {
        loginPageObjects.openPrimarySiteApplications();
        Assert.assertTrue(baseUtil.getDriver().getCurrentUrl().equals(index));
    }

    @Given("^Enter user and password$")
    public void Enter_user_and_password() throws Throwable {
        loginPageObjects.loginToTheApp();
        loginPageObjects.clickTheLoginButton();
        exercisePageObjects.checkLogin();
        Assert.assertTrue(baseUtil.getDriver().getCurrentUrl().equals(home));
    }

    @When("^Insert the name of the exercice in the search field$")
    public void Insert_the_name_of_the_exercice_in_the_search_field() throws Throwable {
        //exercisePageObjects.clickOnLeftMenu();
        //exercisePageObjects.clickOnExerciseItem();
        baseUtil.getDriver().navigate().to(exerciseHome);
        Assert.assertTrue(baseUtil.getDriver().getCurrentUrl().equals(exerciseHome));

    }

    @When("^Check if the exercise exists and verify if the description of the exercise matches with the file$")
    public void Check_if_the_exercise_exists_and_verify_if_the_description_of_the_exercise_matches_with_the_file()
            throws Throwable {
        exercisePageObjects.FillSearchField(file,initialRow,lastRow,initialCell,lastCell);
    }

}
