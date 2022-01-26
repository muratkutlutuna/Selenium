package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Alerts {
    //● Bir class olusturun: Alerts
    WebDriver driver;

    @BeforeClass
    public void setUp() {
//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void acceptAlert() {
        //● Bir metod olusturun: acceptAlert
//        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//        “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(actualResult, expectedResult, "result test is FAILED for accept testing");
    }

    //● Bir metod olusturun: dismissAlert
//        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//        “successfuly” icermedigini test edin.
    @Test
    public void dismissAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult), "result test is FAILED for dismiss testing");

    }

    //● Bir metod olusturun: sendKeysAlert
//        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
//        OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini
//        doğrulayın.
    @Test
    public void sendKeysAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Kutlu");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "Kutlu";
        Assert.assertTrue(actualResult.contains(expectedResult), "result test is FAILED for sendKeys testing");

    }
}
