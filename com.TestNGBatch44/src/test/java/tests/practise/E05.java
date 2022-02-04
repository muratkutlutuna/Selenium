package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class E05 {
    WebDriver driver;
//   ...Exercise5...
//  @BeforeClass ın icerisinde driver i kuralim
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//  maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
//  Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
//  Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.navigate().to("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }
//  @AfterClass ta driver ı kapatalim
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
