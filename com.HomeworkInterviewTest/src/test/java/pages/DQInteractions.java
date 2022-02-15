package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DQInteractions {
    public DQInteractions(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
