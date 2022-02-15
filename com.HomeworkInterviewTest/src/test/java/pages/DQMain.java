package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

//TESTNG POM
//    Go to https://demoqa.com/ write an automated test
// Alerts ( handle all alerts)
// Interactions (Click droppable button and under the simple module drag the “drag me” box to the
// “drop me” box  and verify that dropped.)
// Widgets ( click tool Tips button, hover over the “Hover me to see” button and verify the
// “You Hovered Over the button” message then hover over the “Hover me to see” text field and verify
// “You hovered the text field” message.
public class DQMain {
    //ana menu webelement'leri
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement alertsFrameWindows;
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgets;
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    public WebElement interactions;
    //alert
    @FindBy(xpath = "(//li[@id='item-1'])[2]")
    public WebElement alerts;
    //interactions
    @FindBy(xpath = "(//li[@id='item-3'])[4]")
    public WebElement droppable;
    //widget
    @FindBy(xpath = "(//li[@id='item-6'])[2]")
    public WebElement toolTips;

    public DQMain() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
