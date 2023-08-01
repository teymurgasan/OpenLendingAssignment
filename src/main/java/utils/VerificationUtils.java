package utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ui.BrowserUtils;
import ui.Element;

import java.util.HashSet;
import java.util.List;

public class VerificationUtils {

    private final Logger LOG = LoggerFactory.getLogger(VerificationUtils.class);
    BrowserUtils browserUtils;

    public VerificationUtils(WebDriver driver) {
        browserUtils = new BrowserUtils(driver);
    }

    public void verifyAllTextIsUniques(Element element) {
        LOG.info("Verifying all text in elements '{}' are uniques", element.name);
        List<String> allTexts = browserUtils.getAllElementsText(element);
        Assert.assertEquals(allTexts.size(), new HashSet<>(allTexts).size());
    }
}
