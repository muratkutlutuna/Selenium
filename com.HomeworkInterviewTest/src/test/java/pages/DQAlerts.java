package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DQAlerts {
    public DQAlerts(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//button[@id='alertButton']")
    public WebElement alertButton;
    //================================
    @FindBy(xpath="//button[@id='timerAlertButton']")
    public WebElement timerAlertButton;
    //================================
    @FindBy(xpath="//button[@id='confirmButton']")
    public WebElement confirmButton;
    @FindBy(xpath="//span[@id='confirmResult']")
    public WebElement confirmResult;
    //================================
    @FindBy(xpath="//button[@id='promtButton']")
    public WebElement promtButton;
    @FindBy(xpath="//span[@id='promptResult']")
    public WebElement promptResult;


}
