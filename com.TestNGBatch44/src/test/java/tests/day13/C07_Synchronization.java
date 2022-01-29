package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C07_Synchronization extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Disable']")).isDisplayed());
    }
}
