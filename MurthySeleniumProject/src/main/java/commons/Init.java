package commons;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Init {

    public WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    public WebDriver getDriver(String driverType){
        if (driverType.equalsIgnoreCase("chrome")){
            setPropertyPath();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setAcceptInsecureCerts(true);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.merge(capabilities);
            this.driver= new ChromeDriver(options);
            return driver;
        }
        else if (driverType.equalsIgnoreCase("emulator")){
            setPropertyPath();
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPad");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            this.driver = new ChromeDriver(options);
            return driver;
        }
        return driver;
    }


    public String setPropertyPath(){
        return System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    public ExtentReports getReporting(){
        reports = new ExtentReports("./reports/ExtentReportResults.html", false);
        return reports;
    }

    public ExtentTest getExtentTest(String testName){
        test =  getReporting().startTest(testName);
        return test;
    }
}
