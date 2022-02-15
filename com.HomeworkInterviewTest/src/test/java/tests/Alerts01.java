package tests;

import org.testng.annotations.Test;
import pages.DQMain;
import utilities.Driver;

public class Alerts01 {
    //TESTNG POM
    // Interactions (Click droppable button and under the simple module drag the “drag me” box to the   “drop me” box  and verify that dropped.)
    // Widgets ( click tool Tips button, hover over the “Hover me to see” button and verify the “You Hovered Over the button” message then hover over the “Hover me to see” text field and verify “You hovered the text field” message.

    @Test
    public void alertButton(){
        //    Go to https://demoqa.com/ write an automated test
        Driver.getDriver().get("https://demoqa.com/");
        // Alerts ( handle all alerts)
        DQMain.

    }

}
