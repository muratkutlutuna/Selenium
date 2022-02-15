package tests.day20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class S01 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.trendyol.com/");
        Thread.sleep(5000);
        WebElement selectElement = driver.findElement(By.xpath("//div[@class='country-select']/select"));
        Select select = new Select(selectElement);
        select.selectByValue("TR");
        select.getFirstSelectedOption().click();
        driver.findElement(By.xpath("//button[text()='Select']")).click();
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("Nutella"+Keys.ENTER);
        Thread.sleep(3000);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
