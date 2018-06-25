package pageObjects;

import Model.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 20.6.2017.
 */
public class LoginPageObjects {

    WebDriver driver;
    WebDriverWait wait;
    String baseUrl;
    Login login = new Login();

    By email = By.id("username");
    By password = By.id("password");
    By loginButton = By.id("doLogin");

    public LoginPageObjects(WebDriver driver,WebDriverWait wait,String baseUrl){
        this.driver = driver;
        this.wait = wait;
        this.baseUrl = baseUrl;
    }

    public void openPrimarySiteApplications(){
        StringBuilder url = new StringBuilder();
        url.append(baseUrl);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void loginToTheApp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        WebElement elementEmail = driver.findElement(email);
        elementEmail.sendKeys(login.getEmail());

        WebElement elementPassword = driver.findElement(password);
        elementPassword.sendKeys(login.getPassword());

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public void clickTheLoginButton(){
        WebElement elementLoginButton = driver.findElement(loginButton);
        elementLoginButton.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBASE_URL() {
        return baseUrl;
    }

    public By getEmail() {
        return email;
    }

    public By getPassword() {
        return password;
    }

    public By getLoginButton() {
        return loginButton;
    }
}
