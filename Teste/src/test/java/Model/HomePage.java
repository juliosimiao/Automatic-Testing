package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePageObjects;

/**
 * Created by Julio on 16.6.2017.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    HomePageObjects homePageObjects = new HomePageObjects();


    public HomePage(){
        this.driver = driver;
        this.wait = wait;
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
}
