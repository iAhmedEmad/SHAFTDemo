package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AccountDeletedPage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/delete_account";

    // Constructor
    public AccountDeletedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By accountDeletedText = By.xpath("//b");
    //Actions
    public void navigate(String url){
        driver.browser().navigateToURL(url);
    }

    //Validations
    public AccountDeletedPage assertOnAccountDeleted(String expextedString){
        driver.element().assertThat(accountDeletedText).text().isEqualTo(expextedString).perform();
        return this;
    }


}
