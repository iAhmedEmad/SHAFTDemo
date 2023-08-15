package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SignUpPage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/login";

    // Constructor
    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By newUserName = By.xpath("//input[@type = 'text']");
    private final By newUserEmail = By.xpath("(//input[@type = 'email'])[2]");
    private final By newUserSignupText = By.xpath("//div[@class='signup-form']/h2");
    private final By signupButton = By.xpath("(//button[@type='submit'])[2]");

    // Actions
    public SignUpPage newUserSignup(String name) {
        driver.element().type(newUserName,name);
        String currentDate = String.valueOf(System.currentTimeMillis());
        driver.element().type(newUserEmail,name + currentDate + "@test.com");
        driver.element().click(signupButton);
        return this;
    }
    public void navigate(String url){
        driver.browser().navigateToURL(url);
    }

    // Validations
    public SignUpPage assertOnNewUserSignupWord(String expextedString) {
        driver.element().assertThat(newUserSignupText).text().isEqualTo(expextedString).perform();
        return this;
    }

}
