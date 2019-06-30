import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;
import commons.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Murthy extends Init {

    public HomePage homePage;
    WebDriver webDriver;
    ExtentTest test;
    ExtentReports reports;

    @Parameters({"browserType"})
    @BeforeClass
    public void initiateBrowser(String browserType){
        this.webDriver = getDriver(browserType);
        this.reports = getReporting();

    }

    @Test
    public void testingBrowser(){
        this.test = reports.startTest("testing murthy name");
        homePage = HomePage.getInstance(webDriver);
        homePage.loadUrl("http:www.facebook.com");
        homePage.enterCredential("test", "test");
        Assert.assertEquals("testing", "testin");
        test.log(LogStatus.PASS, " Test case has been passed");

    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
    }

    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
        reports.endTest(test);
        reports.flush();
        reports.close();

    }
}
