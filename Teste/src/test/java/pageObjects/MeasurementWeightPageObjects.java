package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 16.6.2017.
 */
public class MeasurementWeightPageObjects {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    private By weight = By.xpath("//input[@data-did='weightBW']");
    private By waistSize = By.xpath("//input[@data-did='waistSizeBW']");
    private By bodyFatPercent = By.xpath("//input[@data-did='bodyFatPercentBW']");
    private By hours = By.id("measureTimeHourValue");
    private By minutes = By.id("measureTimeMinuteValue");
    private By saveButton = By.className("done");

    public MeasurementWeightPageObjects(WebDriver driver,WebDriverWait wait,String baseUrl){
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
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getBodyWeight()));
    }

    public void clickWeightItem(){
        WebElement elementBodyWeight = driver.findElement(homePageObjects.getBodyWeight());
        elementBodyWeight.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(weight));
    }

    public void enterValues(){
        WebElement elementWeight = driver.findElement(weight);
        elementWeight.sendKeys("87");

        WebElement elementWaistSize = driver.findElement(waistSize);
        elementWaistSize.sendKeys("88");

        WebElement elementBodyFatPercent = driver.findElement(bodyFatPercent);
        elementBodyFatPercent.sendKeys("77");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");
    }

    public void clickToSaveWeight(){
        WebElement elementSaveButton = driver.findElement(saveButton);
        elementSaveButton.click();
    }


}
