package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 19.6.2017.
 */
public class AddActivityPageObjects {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private HomePageObjects homePageObjects = new HomePageObjects();

    By activityDurationHoursValue = By.id("activityDurationHoursValue");
    By activityDurationMinutesValue = By.id("activityDurationMinutesValue");
    By activityDurationSecondsValue = By.id("activityDurationSecondsValue");
    By distance = By.id("distance");
    By notes = By.id("notes");
    By hours = By.id("activityTimeHourValue");
    By minutes = By.id("activityTimeMinuteValue");
    By saveButton = By.className("done");

    public AddActivityPageObjects(WebDriver driver, WebDriverWait wait, String baseUrl){
        this.driver = driver;
        this.wait = wait;
        this.baseUrl = baseUrl;
    }

    public void clickAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getAddButton()));
        WebElement elementAddButton = driver.findElement(homePageObjects.getAddButton());
        elementAddButton.click();
        //wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getActivityItem()));
    }

    public void clickAddActivityItem() throws InterruptedException {
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getActivityItem()));
        WebElement elementActivityItem = driver.findElement(homePageObjects.getActivityItem());
        elementActivityItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(activityDurationHoursValue));
    }

    public void enterValues(){

        WebElement elementActivityDurationHoursValue = driver.findElement(activityDurationHoursValue);
        elementActivityDurationHoursValue.click();
        elementActivityDurationHoursValue.clear();
        elementActivityDurationHoursValue.sendKeys("00");

        WebElement elementActivityDurationMinutesValue = driver.findElement(activityDurationMinutesValue);
        elementActivityDurationMinutesValue.click();
        elementActivityDurationMinutesValue.clear();
        elementActivityDurationMinutesValue.sendKeys("41");

        WebElement elementActivityDurationSecondsValue = driver.findElement(activityDurationSecondsValue);
        elementActivityDurationSecondsValue.click();
        elementActivityDurationSecondsValue.clear();
        elementActivityDurationSecondsValue.sendKeys("57");

        WebElement elementDistance = driver.findElement(distance);
        elementDistance.sendKeys("765");

        WebElement elementNotes = driver.findElement(notes);
        elementNotes.sendKeys("test test test activity");

        WebElement elementHours = driver.findElement(hours);
        elementHours.sendKeys("14");

        WebElement elementMinutes = driver.findElement(minutes);
        elementMinutes.sendKeys("17");

    }

    public void clickToSaveActivity(){
        WebElement elementSaveButton = driver.findElement(saveButton);
        elementSaveButton.click();
    }



}
