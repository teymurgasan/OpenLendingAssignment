package tests.com.openLending;

import engine.PropertiesReader;
import org.testng.annotations.Test;

public class ResourcesTest extends OpenLendingBaseTest {

    @Test
    public void allBlogsAreUniques() {
        browserUtils.goToWebPage(PropertiesReader.URL.getProperty("mainPage"));
        browserUtils.clickElement(mainPage.resourcesButton);
        browserUtils.clickElementWhileExist(resourcesPage.loadMoreButton);
        verificationUtils.verifyAllTextIsUniques(resourcesPage.blogHeader);
    }
}
