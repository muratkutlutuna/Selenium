package tests.day13;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Synchronization extends TestBase {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test01() throws InterruptedException {
//        driver.get("https://the-internet.herokuapp.com/upload");
//        driver.findElement(By.id("file-submit")).click();
//        driver.get("https://www.youtube.com");
//        driver.findElement(By.xpath("//yt-formatted-string[.='Kabul ediyorum']")).click();
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//a[@.=info@techproeducation.com']")).click();
        Thread.sleep(1500);
    }
}
