package pageObjects;

import org.openqa.selenium.By;

/**
 * Created by Julio on 16.6.2017.
 */
public class HomePageObjects {

    By addButton = By.id("addButton");

    By measurementItem = By.xpath("//li[contains(@data-id, 'addmeasure_WAR_AlifePortalportlet')" +
            " and text() = 'Measurement']");
    By activityItem = By.xpath("//li[contains(@data-id, 'addactivity_WAR_AlifePortalportlet')" +
                    " and text() = 'Activity']");

    By morningMeasurement = By.className(" morning-measurement");
    By maxPulseItem = By.className(" max-pulse");
    By bloodSugarItem = By.className(" blood-sugar");
    By bloodPressureItem = By.className("blood-presure");
    By bodyWeight = By.className("body-weight");

    public By getAddButton() {
        return addButton;
    }

    public By getMeasurementItem() {
        return measurementItem;
    }
    public By getActivityItem() { return activityItem;    }

    public By getBodyWeight() { return bodyWeight; }
    public By getBloodPressureItem() { return bloodPressureItem; }
    public By getBloodSugarItem() { return bloodSugarItem; }
    public By getMaxPulseItem() { return maxPulseItem; }
    public By getMorningMeasurement() { return morningMeasurement; }

}
