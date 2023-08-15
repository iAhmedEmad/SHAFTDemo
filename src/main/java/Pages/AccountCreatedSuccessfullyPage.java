package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AccountCreatedSuccessfullyPage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/account_created";

    // Constructor
    public AccountCreatedSuccessfullyPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By accountCreatedText = By.xpath("//b");
    private final By continueAfterAccountCreated = By.xpath("(//a[@href='/'])[3]");
    // Actions
    public AccountCreatedSuccessfullyPage clickContinue() {
        driver.element().click(continueAfterAccountCreated);
        return this;
    }
    public void navigate(String url){
        driver.browser().navigateToURL(url);
    }
    // Validations
    public AccountCreatedSuccessfullyPage assertOnAccountCreatedWord(String expextedString) {
        driver.element().assertThat(accountCreatedText).text().isEqualTo(expextedString).perform();
        return this;
    }
}
