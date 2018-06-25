package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;


/**
 * Created by Julio on 15.6.2017.
 */
public class MeasurementMorningPageObjects{

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    private By weight = By.xpath("//input[@data-did='weight']");
    private By bodyFatPercentage = By.xpath("//input[@data-did='bodyFatPercent']");
    private By restingHeartRateLyingDown = By.xpath("//input[@data-mid='laying']");
    private By restingHeartRateStanding = By.xpath("//input[@data-mid='standing']");
    private By bloodPressureSystolic = By.xpath("//input[@data-mid='systolic']");
    private By bloodPressureDiastolic = By.xpath("//input[@data-mid='diastolic']");
    private By hours = By.id("measureTimeHourValue");
    private By minutes = By.id("measureTimeMinuteValue");
    private By saveButton = By.className("done");

    public MeasurementMorningPageObjects(WebDriver driver, WebDriverWait wait, String baseUrl){
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

    public void clickMorningMeasurementItem(){
        WebElement elementMorningMeasurementItem = driver.findElement(homePageObjects.getMorningMeasurement());
        elementMorningMeasurementItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(weight));
    }

    public void enterValues(){
        WebElement elementWeight = driver.findElement(weight);
        elementWeight.sendKeys("85");

        WebElement elementBodyFatPercentage = driver.findElement(bodyFatPercentage);
        elementBodyFatPercentage.sendKeys("80");

        WebElement elementRestingHeartRateLyingDown = driver.findElement(restingHeartRateLyingDown);
        elementRestingHeartRateLyingDown.sendKeys("80");

        WebElement elementRestingHeartRateStanding = driver.findElement(restingHeartRateStanding);
        elementRestingHeartRateStanding.sendKeys("85");

        WebElement elementBloodPressureSystolic = driver.findElement(bloodPressureSystolic);
        elementBloodPressureSystolic.sendKeys("80");

        WebElement elementBloodPressureDiastolic = driver.findElement(bloodPressureDiastolic);
        elementBloodPressureDiastolic.sendKeys("80");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");
    }

    public void clickToSaveMorningMeasurement(){
        WebElement elementSaveMorningMeasurement = driver.findElement(saveButton);
        elementSaveMorningMeasurement.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public By getWeight() {
        return weight;
    }

    public By getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public By getRestingHeartRateLyingDown() {
        return restingHeartRateLyingDown;
    }

    public By getRestingHeartRateStanding() {
        return restingHeartRateStanding;
    }

    public By getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public By getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public By getHours() {
        return hours;
    }

    public By getMinutes() {
        return minutes;
    }

    public By getSaveButton() {
        return saveButton;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setWeight(By weight) {
        this.weight = weight;
    }

    public void setBodyFatPercentage(By bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public void setRestingHeartRateLyingDown(By restingHeartRateLyingDown) {
        this.restingHeartRateLyingDown = restingHeartRateLyingDown;
    }

    public void setRestingHeartRateStanding(By restingHeartRateStanding) {
        this.restingHeartRateStanding = restingHeartRateStanding;
    }

    public void setBloodPressureSystolic(By bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public void setBloodPressureDiastolic(By bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public void setHours(By hours) {
        this.hours = hours;
    }

    public void setMinutes(By minutes) {
        this.minutes = minutes;
    }

    public void setSaveButton(By saveButton) {
        this.saveButton = saveButton;
    }
}
