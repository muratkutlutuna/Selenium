package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle2 {
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
    public void handleWindows() {
//● Tests package’inda yeni bir class olusturun: WindowHandle2
//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String windowHandleFirst = driver.getWindowHandle();
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert = new SoftAssert();
        String actualText1 = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        String expectedText1 = "Opening a new window";
        softAssert.assertEquals(actualText1, expectedText1, "1.assert");
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "The Internet";
        softAssert.assertEquals(actualTitle1, expectedTitle1, "2.assert");
//● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> windowHandles = driver.getWindowHandles();
        String windowHandleSecond = "";
        for (String handle : windowHandles) {
            if (!handle.equals(windowHandleFirst)) {
                windowHandleSecond = handle;
            }
        }
        driver.switchTo().window(windowHandleSecond);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        softAssert.assertEquals(actualTitle2, expectedTitle2, "3.assert");
//● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText2 = driver.findElement(By.xpath("//h3")).getText();
        String expectedText2 = "New Window";
        softAssert.assertEquals(actualText2, expectedText2, "4.assert");
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandleFirst);
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "The Internet";
        softAssert.assertEquals(actualTitle3, expectedTitle3,"5.assert");
        softAssert.assertAll();
    }
}
