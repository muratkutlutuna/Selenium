package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    @Test
    public void test() throws IOException {
        //amazon ana sayfaya gidelim
        driver.get("https://amazon.com");
        //nutella icin arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String actual = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String expected = "\"Nutella\"";
        Assert.assertEquals(actual,expected);
        //testin calistiginin ispati icin tum sayfanin screenshot'ini alalim

        //tum sayfa screenshot icin 4 adim gerekli
        //1.adim: TakesScreenshot objesi olusturma
        TakesScreenshot tss = (TakesScreenshot)driver;

        //2.adim: kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS = new File("target/screenShot/tumsayfa.png");

        //3.adim: bir dosya daha olusturup screenshot objesi ile screenshot'i alalim
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        //4.adim: geciciresim'i kaydetnmek istedigimiz asil dosyaya copy yapalim
        FileUtils.copyFile(geciciResim,tumSayfaSS);
    }


}
