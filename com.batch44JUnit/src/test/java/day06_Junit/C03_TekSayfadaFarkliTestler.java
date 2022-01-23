package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_TekSayfadaFarkliTestler {
    static WebDriver driver;
    static WebElement searchBox, resultTextElement;
    @Test
    public void test01() {
        //amazon sayfasinda nutella icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        searchBox.sendKeys("nutella"+ Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResultText = resultTextElement.getText();
        String seachedText = "nutella";
        if (actualResultText.contains(seachedText)) {
            System.out.println("Nutella Test PASS");
        } else {
            System.out.println("Nutella test FAILED");
        }
    }
    @Test
    public void test02() {
        //amazon sayfasinda java icin arama yapip sonuc yazisinin java icerdigini test edelim
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("java"+ Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResultText = resultTextElement.getText();
        String seachedText = "java";
        if (actualResultText.contains(seachedText)) {
            System.out.println("java Test PASS");
        } else {
            System.out.println("java test FAILED");
        }
    }
    @Test
    public void test03() {
        //amazon sayfasinda ali icin arama yapip sonuc yazisinin ali icerdigini test edelim
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("ali"+ Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResultText = resultTextElement.getText();
        String seachedText = "ali";
        if (actualResultText.contains(seachedText)) {
            System.out.println("ali Test PASS");
        } else {
            System.out.println("ali test FAILED");
        }
    }
    @BeforeClass
    public static void ayarlariDuzenle (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    }
    @AfterClass
    public static void ortaligiTopla() {
        driver.quit();
    }
}
