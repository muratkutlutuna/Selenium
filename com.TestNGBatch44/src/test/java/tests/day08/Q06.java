package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q06 {
    WebDriver driver;
    String expectedOutput, actualOutput;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    @Test(priority = 0)
    public void isTextOpening_a_new_window() {
        driver.get("https://the-internet.herokuapp.com/windows");
        expectedOutput = "Opening a new window";
        actualOutput = driver.findElement(By.xpath("//h3[text()='"+expectedOutput+"']")).getText();
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    @Test(priority = 1)
    public void isTitleThe_Internet() {
        expectedOutput = "The Internet";
        actualOutput = driver.getTitle();
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    //● Click Here butonuna basın.
    //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    @Test(priority = 2)
    public void isTitleNew_Window() throws InterruptedException {
        expectedOutput = "New Window";
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(2000);
        actualOutput = driver.getTitle();
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    @Test(priority = 3)
    public void isTextNew_Window() {
        expectedOutput = "New Window";
        actualOutput = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    @Test(priority = 4)
    public void isTitleThe_Internet_again() {
        driver.navigate().back();
        expectedOutput = "The Internet";
        actualOutput = driver.getTitle();
        Assert.assertEquals(actualOutput, expectedOutput);
    }
}


