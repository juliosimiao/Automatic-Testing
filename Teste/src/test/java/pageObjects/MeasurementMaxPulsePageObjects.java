package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 16.6.2017.
 */
public class MeasurementMaxPulsePageObjects{

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    private By maxPulse = By.xpath("//input[@data-did='maxPulse']");
    private By hours = By.id("measureTimeHourValue");
    private By minutes = By.id("measureTimeMinuteValue");
    private By saveButton = By.className("done");

    public MeasurementMaxPulsePageObjects(WebDriver driver,WebDriverWait wait, String baseUrl){
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

    public void clickMaxPulseItem(){
        WebElement elementMaxPulseItem = driver.findElement(homePageObjects.getMaxPulseItem());
        elementMaxPulseItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(maxPulse));
    }

    public void enterValues(){
        WebElement elementMaxPulse = driver.findElement(maxPulse);
        elementMaxPulse.sendKeys("80");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");
    }

    public void clickToSaveMaxPulse(){
        WebElement elementSaveMaxPulse = driver.findElement(saveButton);
        elementSaveMaxPulse.click();
    }








}
