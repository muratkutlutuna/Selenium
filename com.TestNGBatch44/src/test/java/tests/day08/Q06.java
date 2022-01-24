package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    @Test
    public void isTextOpening_a_new_window(){
        expectedOutput = "Opening a new window";
        actualOutput = driver.findElement(By.xpath("//h3[text()='Opening a new window'")).getText();
        Assert.assertEquals(actualOutput, expectedOutput);
    }
    //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    @Test
    public void isTitleThe_Internet(){
        expectedOutput = "The Internet";
        actualOutput = driver.getTitle();
        Assert.assertEquals(actualOutput, expectedOutput);
    }
    //● Click Here butonuna basın.
    //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
}
