package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IframeTest {
//● Bir class olusturun: IframeTest

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");    }
    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        //● Bir metod olusturun: iframeTest
//        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement text = driver.findElement(By.xpath("//h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(text.isDisplayed(),"Iframe text is invisible!");
        System.out.println("Iframe text is visible!");
//        ○ Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        driver.findElement(By.tagName("p")).clear();
        driver.findElement(By.tagName("p")).sendKeys("Merhaba Dunya!");
        //Thread.sleep(2000);
//        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        String actualOutput = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText();
        String expectedOutput = "Elemental Selenium";
        driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();
        driver.switchTo().defaultContent();
        softAssert.assertEquals(actualOutput,expectedOutput,"Output is WRONG!");
        System.out.println("Output is RIGHT!");
        softAssert.assertAll();
    }
}
