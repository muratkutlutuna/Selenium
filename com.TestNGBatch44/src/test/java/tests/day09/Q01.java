package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Q01 {
    ///*
//...1. Egzersiz...
//BeforeClass ile driver ı olusturun ve class icinde statik yapin
//Maximize edin, 15 sn
//http://www.google.com'dan giderken
//arama kutusuna "Yeşil Yol" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna "Öngörü" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna "Benjamin Button'ın Tuhaf Hikayesi" yazip, cikan sonuc sayisini yazdirin
//Ders Sonrası ile
//
// */
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.google.com");
        WebElement accept = driver.findElement(By.xpath("//div[text()='Ich stimme zu']"));
        if (accept.isDisplayed()) {
            accept.click();
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @After
    public void testtenSonra(){
        System.out.println("sonuc yaizi: " + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
        driver.findElement(By.xpath("//input[@role='combobox']")).clear();
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Yesil Yol"+ Keys.ENTER);
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Ongoru"+ Keys.ENTER);
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Benjamin Button"+ Keys.ENTER);
    }
}
