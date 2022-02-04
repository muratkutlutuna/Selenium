package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q05 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void Test() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //click on action dialog button
        //if need use explicitly wait
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Action Dialog']"))));
        driver.findElement(By.xpath("//button[.='Action Dialog']")).click();
        //click on the ok button
        w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Ok']"))));
        driver.findElement(By.xpath("//button[.='Ok']")).click();
        //accept the alert message
        w.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
