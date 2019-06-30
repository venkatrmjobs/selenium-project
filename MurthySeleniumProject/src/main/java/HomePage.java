import commons.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    public static HomePage homePage;
    public WebDriver webDriver;

    @FindBy(xpath = "//*[@id='email']")
    WebElement user;

    @FindBy(xpath = "//*[@id='pass']")
    WebElement passWord;

    public void enterCredential(String userName, String pwd){
        user.sendKeys(userName);
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
}
