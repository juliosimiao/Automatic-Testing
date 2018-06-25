package pageObjects;

import Steps.MeasurementBloodSugarStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 16.6.2017.
 */
public class MeasurementBloodSugarPageObjects {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    private By bloodSugar = By.className("number");
    private By hours = By.id("measureTimeHourValue");
    private By minutes = By.id("measureTimeMinuteValue");
    private By saveButton = By.className("done");

    public MeasurementBloodSugarPageObjects(WebDriver driver, WebDriverWait wait, String baseUrl){
        this.driver = driver;
        this.wait = wait;
        this.baseUrl = baseUrl;
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getAddButton()));
        WebElement elementAddButton = driver.findElement(homePageObjects.getAddButton());
        elementAddButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getMeasurementItem()));
    }

    public void clickMeasurementItem(){
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getMeasurementItem()));
        WebElement elementMeasurementItem = driver.findElement(homePageObjects.getMeasurementItem());
        elementMeasurementItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getMorningMeasurement()));
    }

    public void clickBloodSugarItem(){
        WebElement elementBloodSugarItem = driver.findElement(homePageObjects.getBloodSugarItem());
        elementBloodSugarItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bloodSugar));
    }

    public void enterValues(){
        WebElement elementBloodSugar = driver.findElement(bloodSugar);
        elementBloodSugar.sendKeys("80");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");
    }

    public void clickToSaveBloodSugar(){
        WebElement elementSaveButton = driver.findElement(saveButton);
        elementSaveButton.click();
    }

}
