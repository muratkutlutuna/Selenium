package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class E04 extends TestBase {
    // ...Exercise4...
    //    https://www.teknosa.com/ adresine gidiniz
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.teknosa.com/");
        //    arama cubuguna oppo yazip enter deyiniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='search-button js_search_button sbx-fake btn-search']"))));
        driver.findElement(By.xpath("//button[@class='search-button js_search_button sbx-fake btn-search']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys("oppo").sendKeys(Keys.ENTER).perform();
        //    sonuc sayisini yazdiriniz
        System.out.println("Result = " + driver.findElement(By.xpath("//div[@class='plp-info']")).getText());
        //    cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        //    sepete ekleyiniz
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='addToCartButton']"))));
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        //    sepetime git e tiklayiniz
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='btn btn-secondary']"))));
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        //    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        String ozetWebElementi = driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText();
        System.out.println("ozetWebElementi = " + ozetWebElementi);
        //    Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        //    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        String hosgeldiniz = driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText();
        System.out.println("hosgeldinizElement = " + hosgeldiniz);
    }
    //    driver i kapatiniz
}
