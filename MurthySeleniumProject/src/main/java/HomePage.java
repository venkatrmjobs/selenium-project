import commons.Init;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage{

    public static HomePage homePage;
    public WebDriver webDriver;

    @FindBy(xpath = "//*[@id='email']")
    WebElement user;

    @FindBy(xpath = "//*[@id='pass']")
    WebElement passWord;

    @FindBy(xpath = "//*[@id = 'birthday-help']")
    WebElement birthDayHelp;

    @FindBy(xpath = "//*[@id= 'month']//option")
    List<WebElement> monthDropDown;

    @FindBy(xpath = "//*[@id= 'month']")
    WebElement month;

    public void enterCredential(String userName, String pwd){
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", user);
        user.sendKeys(userName);
        System.out.println("userID " + user.getAttribute("value"));
        passWord.sendKeys(pwd);
    }

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public static HomePage getInstance(WebDriver webDriver){
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        return homePage;
    }

    public void loadUrl(String url){
        webDriver.get(url);
    }

    public String getBirthDayToolTipText(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(birthDayHelp).build().perform();
        return "";
    }

    public List<String> getTotalMonths() throws Exception{

        List<String> months = new ArrayList<>();
        for (WebElement monthName : monthDropDown) {
            selectMonth(monthName.getText());
            months.add(monthName.getText());
        }
        return months;
    }

    public void selectGender(String gender){

        String inputXpath = "//span[@data-type = 'radio']//span//label[contains(text(), '%s')]";
        WebElement ele =  webDriver.findElement(By.xpath(String.format(inputXpath, gender))).findElement(By.xpath("./preceding-sibling::input"));
        ele.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
        webDriver.switchTo().frame("testing");
        webDriver.switchTo().defaultContent();
        webDriver.getWindowHandle();
        webDriver.getWindowHandles();
        webDriver.switchTo().window("");

    }

    public void selectMonth(String monthName) throws Exception{
//        Select sel = new Select(month);
//        sel.selectByVisibleText(monthName);
        month.sendKeys(monthName);
        Thread.sleep(2000);
    }
}