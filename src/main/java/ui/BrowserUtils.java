package ui;

import engine.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BrowserUtils {

    private final Logger LOG = LoggerFactory.getLogger(BrowserUtils.class);
    WebDriver driver;
    WebDriverWait wait;
    FluentWait<WebDriver> fluentWait;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public static String takeScreenShot(String testName) {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + testName + System.currentTimeMillis() + ".png";
        File destFile = new File(destination);

        try {
            FileUtils.copyFile(src, destFile);
        } catch (IOException ignored) {
        }

        return destination;
    }

    public void goToWebPage(String url) {
        driver.navigate().to(url);
        LOG.info("Navigate to page with url '{}'", url);
    }

    public void clickElement(Element element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element.locator));
        driver.findElement(element.locator).click();
        LOG.info("Click element '{}'", element.name);
    }

    public void clickElementWhileExist(Element element) {
        try {
            wait.until((Function<WebDriver, WebElement>) driver -> {
                driver.findElement(element.locator).click();
                LOG.info("Click element '{}'", element.name);
                return null;
            });
        } catch (Exception e) {
            LOG.info("No element '{}' on Page", element.name);
        }

    }

    public List<String> getAllElementsText(Element element) {
        List<WebElement> elements = driver.findElements(element.locator);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
