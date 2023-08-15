package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Menu {
    private SHAFT.GUI.WebDriver driver;

    public Menu(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    ////////////////// Locators \\\\\\\\\\\\\\\\\
    private final By loginButton = By.xpath("//a[@href='/login']");
    private final By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private final By successfulLoginText = By.xpath("(//ul[@class='nav navbar-nav']//a)[10]");

    ///////////////// Actions \\\\\\\\\\\\\\\\\\\\\
    public Menu clickSignupAndLoginButton() {
        driver.element().click(loginButton);
        return this;
    }
    public Menu deleteAccount() {
        driver.element().click(deleteAccountButton);
        return this;
    }

    ///////////////// Validations \\\\\\\\\\\\\\\\\\\
    public Menu assertOnLoggedInAsdWord(String expextedString) {
        driver.element().assertThat(successfulLoginText).text().isEqualTo("Logged in as "+expextedString).perform();
        return this;
    }

}
