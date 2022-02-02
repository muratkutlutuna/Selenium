package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class T01_TeamWork extends TestBase {

//1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement ourProductsIframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(ourProductsIframe);
//2. “Our Products” butonuna basin
        driver.findElement(By.xpath("//a[.='Our Products']")).click();
        //driver.switchTo().frame(ourProductsIframe);
//3. “Cameras product”i tiklayin
        Thread.sleep(3000);

        driver.findElement(By.xpath("//p[text()='Cameras']")).click();

//4. Popup mesajini yazdirin
        Thread.sleep(3000);
        WebElement alertElement = driver.findElement(By.xpath("//div[@class='modal-body']/p"));
        System.out.println("alertElement.getText() = " + alertElement.getText());
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[.='Close']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@id='nav-title']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://webdriveruniversity.com/index.html");
    }


//6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
}
