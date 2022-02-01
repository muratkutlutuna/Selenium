package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebelement extends TestBase {

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

        //1.adim: screenshot cekecegimiz elementi locate edelim
        //sonuc elementi zaten locate ettik
        //2.adim: screenshot'i kaydedecegimiz bir file olusturalim

        File webElementSS = new File("target/screenShot/webelement.jpeg");

        //3.adim
        File geciciResim = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,webElementSS);




    }

}
