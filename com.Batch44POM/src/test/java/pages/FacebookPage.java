package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//button[@data-cookiebanner='accept_button']")
    public WebElement cookies;

    @FindBy(xpath="//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    public WebElement createAccount;

    @FindBy(xpath="//input[@class='inputtext _55r1 _6luy']")
    public WebElement mailTel;

    @FindBy(xpath="//input[@class='inputtext _55r1 _6luy _9npi']")
    public WebElement password;

    @FindBy(xpath="//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement signInButton;

    @FindBy(className="_9ay7")
    public WebElement incorrectText;

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
