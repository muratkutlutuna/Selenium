package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DQWidgets {
    public DQWidgets(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
