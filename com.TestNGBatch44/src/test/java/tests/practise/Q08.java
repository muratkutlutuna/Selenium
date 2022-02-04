package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Q08 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// web sitesini maximize yapin
        driver.manage().window().maximize();
        WebElement emoojisIframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(emoojisIframe);
// ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
// tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement w : emojis){
            w.click();
        }
        System.out.println("ogeler tiklandi");
// parent iframe e geri donun
        driver.switchTo().defaultContent();
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("hello");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("sad")
                .sendKeys(Keys.TAB).sendKeys("mountain")
                .sendKeys(Keys.TAB).sendKeys("chicken")
                .sendKeys(Keys.TAB).sendKeys("football")
                .sendKeys(Keys.TAB).sendKeys("sea")
                .sendKeys(Keys.TAB).sendKeys("pencil")
                .sendKeys(Keys.TAB).sendKeys("right")
                .sendKeys(Keys.TAB).sendKeys("usa")
                .sendKeys(Keys.TAB).sendKeys(":D")
                .sendKeys(Keys.TAB).sendKeys(":D")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//  apply button a basin

        Thread.sleep(3000);
    }
}
