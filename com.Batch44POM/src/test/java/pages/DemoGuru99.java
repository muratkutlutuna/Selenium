package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuru99 {
    @FindBy(xpath = "(//a[@class='button button-orange'])[5]")
    public WebElement bankButton;
    @FindBy(xpath = "(//a[@class='button button-orange'])[6]")
    public WebElement salesButton;
    @FindBy(xpath = "(//a[@class='button button-orange'])[2]")
    public WebElement first5000Button;
    @FindBy(xpath = "(//a[@class='button button-orange'])[4]")
    public WebElement second5000Button;
    @FindBy(xpath = "(//div[@class='ui-widget-content'])[2]")
    public WebElement debitAccountArea;
    @FindBy(xpath = "(//div[@class='ui-widget-content'])[3]")
    public WebElement debitAmountArea;
    @FindBy(xpath = "(//div[@class='ui-widget-content'])[4]")
    public WebElement creditAccountArea;
    @FindBy(xpath = "(//div[@class='ui-widget-content'])[5]")
    public WebElement creditAmountArea;
    @FindBy(xpath = "(//a[@class='button button-green'])[1]")
    public WebElement perfectButton;

    public DemoGuru99() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
