package verifications;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestConfigurations {
    SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/");
        //SHAFT.Properties.reporting.set().openAllureReportAfterExecution(true);
    }
}
