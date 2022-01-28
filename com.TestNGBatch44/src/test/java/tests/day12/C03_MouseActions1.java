package tests.day12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {
//1- Yeni bir class olusturalim: MouseActions1
//2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
//3- Cizili alan uzerinde sag click yapalim
//4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
//5- Tamam diyerek alert’I kapatalim
//6- Elemental Selenium linkine tiklayalim
//7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        /*Actions actions = new Actions(driver);
        WebElement boxElement = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(boxElement).perform();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Thread.sleep(2000);
        Assert.assertEquals(actualText, expectedText, actualText);
        driver.switchTo().alert().accept();
        WebElement elementalElement = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        actions.click(elementalElement).perform();
        String actualOutput = driver.findElement(By.xpath("//h1")).getText();
        String expectedOutput = "Elemental Selenium";
        Assert.assertEquals(actualOutput, expectedOutput,"there is no text located in h1 tag");*/
//3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ikinciSayfaHandleDegeri="";
        Set<String> handleSeti= driver.getWindowHandles();
        for (String each:handleSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.tagName("h1"));
        String actualIkinciSayfaYazi=ikinciSayfaYaziElementi.getText();
        String expectedIkinciSayfaYazisi="Elemental Selenium";
        Assert.assertEquals(actualIkinciSayfaYazi,expectedIkinciSayfaYazisi);
    }


}
