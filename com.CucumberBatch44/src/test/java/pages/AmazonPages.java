package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPages {
    public AmazonPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "[id=\"twotabsearchtextbox\"]")
    public WebElement searchBoxElement;
    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement resultTextElement;

}
