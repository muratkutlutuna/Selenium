package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.time.Duration;


public class C03_BestBuyAssertions {
    static WebDriver driver;
    static String expectedUrl, actualUrl;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
//) Bir class oluşturun: BestBuyAssertions
//2) https://www.bestbuy.com/ Adresine gidin farkli test
// method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
//○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        expectedUrl = "https://www.bestbuy.com/";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Lutfen Test degerlerini gozden gecirin",expectedUrl, actualUrl);
//○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Reset";
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
        System.out.println("bu satir calismaz");
//○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement element = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo Gorunmuyor", element.isDisplayed());
//○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test
        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francais.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
