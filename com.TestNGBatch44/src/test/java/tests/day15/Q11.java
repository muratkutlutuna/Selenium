package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Q11 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //      go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //      get the first window
        String windowHandleFirst = driver.getWindowHandle();
        //driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        //      clicking on click here button
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(3000);
        //      get all the window in the set
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
        }
        //      switch to window
        driver.switchTo().newWindow(WindowType.TAB);
        //      input email id (somepne@gmail.com) and type something in that input

        //      Clicking on the submit button
        //      verify title as expected
        //      switch to first window
    }

}
