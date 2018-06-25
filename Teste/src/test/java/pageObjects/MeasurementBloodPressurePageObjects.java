package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 16.6.2017.
 */
public class MeasurementBloodPressurePageObjects {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    private By heartRate = By.xpath("//input[@data-did='heartrateBP']");
    private By bloodPressureSystolic = By.xpath("//input[@data-mid='systolic']");
    private By bloodPressureDiastolic = By.xpath("//input[@data-mid='diastolic']");
    private By hours = By.id("measureTimeHourValue");
    private By minutes = By.id("measureTimeMinuteValue");
    private By saveButton = By.className("done");

    public MeasurementBloodPressurePageObjects(WebDriver driver, WebDriverWait wait, String baseUrl){
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
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getBloodPressureItem()));
    }

    public void clickBloodPressureItem(){
        WebElement elementBloodPressureItem = driver.findElement(homePageObjects.getBloodPressureItem());
        elementBloodPressureItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(heartRate));
    }

    public void enterValues(){
        WebElement elementHeartRate = driver.findElement(heartRate);
        elementHeartRate.sendKeys("80");

        WebElement elementBloodPressureSystolic = driver.findElement(bloodPressureSystolic);
        elementBloodPressureSystolic.sendKeys("81");

        WebElement elementBloodPressureDiastolic = driver.findElement(bloodPressureDiastolic);
        elementBloodPressureDiastolic.sendKeys("79");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");
    }

    public void clickToSaveBloodPressure(){
        WebElement elementSaveButton = driver.findElement(saveButton);
        elementSaveButton.click();
    }
}
