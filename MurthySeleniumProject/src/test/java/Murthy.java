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

    private HomePage homePage;
    private WebDriver webDriver;
    ExtentTest test;
    ExtentReports reports;

    @Parameters({"browserType"})
    @BeforeClass
    public void initiateBrowser(String browserType){
        this.webDriver = getDriver(browserType);
        this.reports = getReporting();

    }

    @Test
    public void testingBrowser() throws Exception{
        this.test = reports.startTest("testing murthy name");
        homePage = HomePage.getInstance(webDriver);
        homePage.loadUrl("https://www.facebook.com/");
        //homePage.getBirthDayToolTipText();

        homePage.selectGender("Custom");
        homePage.getTotalMonths();
        homePage.enterCredential("test", "test");
        Assert.assertEquals("testing", "testing");
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

    @Test(dataProvider="getData")
    public void setData(String username, String password)
    {
        System.out.println("you have provided username as::"+username);
        System.out.println("you have provided password as::"+password);
    }

    @DataProvider
    public Object[][] getData()
    {

        /*
        row s and columns
        object[1] [10]
         */
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[3][2];

        // 1st row
        data[0][0] ="sampleuser1";
        data[0][1] = "abcdef";

        // 2nd row
        data[1][0] ="testuser2";
        data[1][1] = "zxcvb";

        // 3rd row
        data[2][0] ="guestuser3";
        data[2][1] = "pass123";

        return data;
    }
    @Test(dataProvider = "loginData")
    public void murthyTesting(){

    }

    @DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object[2][20];
        data[0][0] = 123;
        return data;
    }
    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
        reports.endTest(test);
        reports.flush();
        reports.close();

    }
}
