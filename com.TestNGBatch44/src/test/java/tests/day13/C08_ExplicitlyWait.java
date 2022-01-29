package tests.day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C08_ExplicitlyWait extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        //wait.until(ExpectedConditions.visibilityOf());
    }
}
