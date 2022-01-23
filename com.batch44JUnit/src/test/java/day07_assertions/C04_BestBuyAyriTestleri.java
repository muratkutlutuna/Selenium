package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestleri {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void urltesti() {
//○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Lutfen Test degerlerini gozden gecirin",expectedUrl, actualUrl);

    }

    @Test
    public void titleTesti(){
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Reset";
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
        System.out.println("bu satir calismaz");

    }

    @Test
    public void logoTesti(){
        WebElement element = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo Gorunmuyor", element.isDisplayed());

    }

    @Test
    public void francaisTesti(){
        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francais.isDisplayed());

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }


}
