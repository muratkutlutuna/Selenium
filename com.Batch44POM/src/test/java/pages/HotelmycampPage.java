package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelmycampPage {
    public HotelmycampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginLink;

    @FindBy(id = "UserName")
    public WebElement usernameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement incorrectAccessText;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
