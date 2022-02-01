package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.TestRunner.PriorityWeight.priority;

public class C05_JsExecutorScrollIntoView extends TestBase {
    //1- Yeni bir class olusturun : ScroolInto
    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin

    @Test(priority=-500)
    public void scrollAction() throws InterruptedException {

        driver.get("https://hotelmycamp.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(3000);
        //4- istediginiz oda inceleme sayfasi acildigini test edin
    }
    @Test
    public void scrollJsExecutor() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);

        JavascriptExecutor jse= (JavascriptExecutor)driver;
        WebElement webElementOdaIncele = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",webElementOdaIncele);
        Thread.sleep(2000);

        jse.executeScript("arguments[0].click();",webElementOdaIncele);
        Thread.sleep(2000);

    }
}
