package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/";

    // constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators

    // Actions

    public void navigate(){
        driver.browser().navigateToURL(url);
    }
    // Validations
    public Menu assertOnPageTitle(String expextedString) {
        driver.browser().assertThat().title().isEqualTo(expextedString).perform();
        return new Menu(driver);
    }

}
