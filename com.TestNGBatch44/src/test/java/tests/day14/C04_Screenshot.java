package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screenshot extends TestBase {
    @Test
    public void screenTest() throws IOException {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        //1.adim: tum sayfanin screenshot'ini almak icin; TakeScreenShot objesi olusturalim,
        //deger olarak driver'imizi atayalim
        //deger olarak driver'i kabul etmesi icin casting yapmamiz gerekir

        TakesScreenshot tss = (TakesScreenshot)driver;

        //2.adim: tum sayfanin screenshot'ini almak icin birFile olusturalim ve
        //dosya yolunu belirtelim

        File tumSayfaSS = new File("src\\tumSayfa.png");

        //3.adim olusturdugumuz File ile takeScreenshoot objesini iliskilendirelim

        tumSayfaSS = tss.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(tumSayfaSS, new File("src\\tumSayfa.png"));
    }
}

