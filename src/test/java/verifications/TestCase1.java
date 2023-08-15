package verifications;

import Pages.*;
import org.testng.annotations.Test;

public class TestCase1 extends TestConfigurations {
    /*@Test(description = "Test Exercise")
    public void testExercise() {
        // Fluent Design (Complete Fluency)
        new HomePage(driver,sa).
                assertOnPageTitle("Automation Exercise").
                clickSignupAndLoginButton().
                assertOnNewUserSignupWord("New User Signup!").
                newUserSignup("Ahmed").
                assertOnEnterAccountInformationWord("ENTER ACCOUNT INFORMATION").
                createAccount("Ahmed","Emad","_VOIS","here","There","Cairo","Cairo","123","12345678910").
                assertOnAccountCreatedWord("ACCOUNT CREATED!").
                clickContinue().
                assertOnLoggedInAsdWord("Logged in as Ahmed").
                deleteAccount().
                assertOnAccountDeleted("ACCOUNT DELETED!");
    }*/
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

        new  Menu(driver).
                assertOnLoggedInAsdWord("Ahmed").
                deleteAccount();

        new AccountDeletedPage(driver).
                assertOnAccountDeleted("ACCOUNT DELETED!");
    }
}
