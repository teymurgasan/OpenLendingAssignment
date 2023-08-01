package engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.BrowserUtils;

public class Listeners implements ITestListener {

    private static final Logger LOG = LoggerFactory.getLogger(Listeners.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("{} test is started", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("{} test is successfully passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.warn("{} test failed", result.getName());

        String destination = BrowserUtils.takeScreenShot(result.getName());
        LOG.info("Screenshot was saved at destination '{}'", destination);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.warn("'{} test was skipped", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
