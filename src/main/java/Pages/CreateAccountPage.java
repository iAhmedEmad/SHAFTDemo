package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CreateAccountPage {
    private SHAFT.GUI.WebDriver driver;
    String url = "https://automationexercise.com/signup";

    // Constructor
    public CreateAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By TitleMrCheck = By.xpath("(//input[@type='radio'])[1]");
    private final By password = By.xpath("//input[@type='password']");
    private final By newsLetterSignUpCheckbox = By.id("newsletter");
    private final By addressInfoFirstName = By.xpath("//input[@id='first_name']");
    private final By addressInfoLastName = By.xpath("//input[@id='last_name']");
    private final By addressInfoCompany = By.xpath("//input[@id='company']");
    private final By addressInfoAddress = By.xpath("//input[@id='address1']");
    private final By addressInfoAddress2 = By.xpath("//input[@id='address2']");
    private final By addressInfoState = By.xpath("//input[@id='state']");
    private final By addressInfoCity = By.xpath("//input[@id='city']");
    private final By addressInfoZipcode = By.xpath("//input[@id='zipcode']");
    private final By addressInfoMobileNumber = By.xpath("//input[@id='mobile_number']");
    private final By dayDropDownMenu = By.xpath("//select[@id='days']");
    private final By daySelected = By.xpath("//select[@id='days']//option[@value='30']");
    private final By monthDropDownMenu = By.xpath("//select[@id='months']");
    private final By monthSelected = By.xpath("//select[@id='months']//option[@value='11']");
    private final By yearDropDownMenu = By.xpath("//select[@id='years']");
    private final By yearSelected = By.xpath("//select[@id='years']//option[@value='1997']");
    private final By createAccountButton = By.xpath("(//button[@type='submit'])[1]");
    private final By enterAccountInformationWord = By.xpath("(//h2[@class='title text-center'])[1]");

    // Actions
    public CreateAccountPage createAccount(String firstName, String lastName, String Company, String address1, String address2, String state, String City, String zipcode, String mobileNumber ) {
        driver.element().click(TitleMrCheck);
        driver.element().type(this.password,firstName);
        driver.element().click(newsLetterSignUpCheckbox);
        driver.element().type(addressInfoFirstName,firstName);
        driver.element().type(addressInfoLastName,lastName);
        driver.element().type(addressInfoCompany,Company);
        driver.element().type(addressInfoAddress,address1);
        driver.element().type(addressInfoAddress2,address2);
        driver.element().type(addressInfoState,state);
        driver.element().type(addressInfoCity,City);
        driver.element().type(addressInfoZipcode,zipcode);
        driver.element().type(addressInfoZipcode,zipcode);
        driver.element().type(addressInfoMobileNumber,mobileNumber);
        driver.element().click(dayDropDownMenu);
        driver.element().click(dayDropDownMenu);
        driver.element().click(monthDropDownMenu);
        driver.element().click(monthSelected);
        driver.element().click(yearDropDownMenu);
        driver.element().click(yearSelected);
        driver.element().click(createAccountButton);
        return new CreateAccountPage(driver);
    }
    public void navigate(String url){
        driver.browser().navigateToURL(url);
    }

    // Validations
    public CreateAccountPage assertOnEnterAccountInformationWord(String expextedString) {
        driver.element().assertThat(enterAccountInformationWord).text().isEqualTo(expextedString).perform();
        return this;
    }

}
