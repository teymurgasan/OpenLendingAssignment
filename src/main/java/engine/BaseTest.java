package engine;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.BrowserUtils;
import utils.VerificationUtils;

public class BaseTest {

    protected BrowserUtils browserUtils;
    protected VerificationUtils verificationUtils;

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        browserUtils = new BrowserUtils(driver);
        verificationUtils = new VerificationUtils(driver);
    }

    @AfterMethod
    public void finalize(){
        Driver.closeDriver();
    }
}
