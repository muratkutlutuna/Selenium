package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {
//Yeni bir class olusturalim: D15_MouseActions4
//1- https://www.facebook.com adresine gidelim
//2- Yeni hesap olustur butonuna basalim
//3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
//4- Kaydol tusuna basalim
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']")).click();
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement element = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(element)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
        Thread.sleep(1000);
    }
    @AfterClass
    public void tearDown() {}
}
