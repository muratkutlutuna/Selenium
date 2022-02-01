package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JavascriptExecuter extends TestBase {
    //amazon a gidip
    //sell linkine javascript executer ile tiklayalim
    //ilgili sayfaya gittigimiz test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        //1.adim: JsExecuter objesi olusturalim ve driver'i cast edelim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //2.adim ilgili web elementi locate edelim
        WebElement sellelementi = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
        //3.adim: ilgili script ve argument (bizim web elementimiz) objemiz uzerinden
        //  execuuteScript method'unu calistiralim
        jse.executeScript("arguments[0].click();",sellelementi);
        Thread.sleep(3000);
        //ilgili sayfaya gittiginizi test edin
    }

}
