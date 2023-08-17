package verifications;

import Pages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {
    SHAFT.GUI.WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/");
    }
    @Test(description = "Test Exercise")
    public void testExercise() {
        new HomePage(driver).
                assertOnPageTitle("Automation Exercise");

        new Menu(driver).
                clickSignupAndLoginButton();

        new SignUpPage(driver).
                assertOnNewUserSignupWord("New User Signup!").
                newUserSignup("Ahmed");

        new CreateAccountPage(driver).
                assertOnEnterAccountInformationWord("ENTER ACCOUNT INFORMATION").
                createAccount("Ahmed","Emad","_VOIS","here","There","Cairo","Cairo","123","12345678910");

        new AccountCreatedSuccessfullyPage(driver).
                assertOnAccountCreatedWord("ACCOUNT CREATED!").
                clickContinue();

        /*new  Menu(driver).
                assertOnLoggedInAsdWord("Ahmed").
                deleteAccount();

        new AccountDeletedPage(driver).
                assertOnAccountDeleted("ACCOUNT DELETED!");*/
    }
}
