package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julio on 15.6.2017.
 */
public class BaseUtil {

    public WebDriver driver;
    public WebDriverWait wait;
    public String BASE_URL;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }
}
