package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q07 {
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test01(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
    }
    @Test
    public void test02(){
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        
    }
    @Test
    public void test03(){

    }
    @Test
    public void test04(){

    }
    @Test
    public void test05(){

    }
}
