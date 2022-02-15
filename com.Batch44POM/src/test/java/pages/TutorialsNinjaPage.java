package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TutorialsNinjaPage {
    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[6]")
    public WebElement phonesPdasButton;
    @FindBy(xpath = "//div[@class='caption']/h4")
    public List<WebElement> phoneList;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    public List<WebElement> phoneListAddToChart;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement basket;
    @FindBy(xpath = "//td[@class='text-left']/a")
    public List<WebElement> phoneListInBasket;
    @FindBy(xpath = "//tr[4]/td[2]")
    public WebElement totalPrice;

    public TutorialsNinjaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
