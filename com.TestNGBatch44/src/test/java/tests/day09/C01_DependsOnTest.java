package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class C01_DependsOnTest {
    //      ● Bir class oluşturun: DependsOnTest
    WebDriver driver;
    String actualTitle, searchedWord;
    WebElement logoElement, searchBox;

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

    //      ● https://www.amazon.com/ adresine gidin.
//    1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void logoTest() {
        driver.get("https://www.amazon.com/");
        logoElement = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElement.isDisplayed());
    }

    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
//    arama yapin ve aramanizin gerceklestigini Test edin
    @Test(dependsOnMethods = "logoTest")
    public void searchingTest() {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        actualTitle = driver.getTitle();
        searchedWord = "Nutella";
        Assert.assertTrue(actualTitle.contains(searchedWord));
    }
//    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
//      $14.99 oldugunu test edin
    @Test(dependsOnMethods="searchingTest")
    public void priceTest(){
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement productPriceElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
        String expectedProductPrice = productPriceElement.getText();
        String searchedPrice = "$14.99";
        Assert.assertTrue(expectedProductPrice.contains(searchedPrice));
    }

}
