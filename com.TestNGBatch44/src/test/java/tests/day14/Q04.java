package tests.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04 {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high
     *     T2 : Verify item prices are sorted from low to high with soft Assert
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        WebElement navigator = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(navigator);
        select.selectByValue("lohi");
        String expected = "PRICE (LOW TO HIGH)";
        String actual = driver.findElement(By.className("active_option")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected, "prices are not sorted as expected");
        softAssert.assertAll();

    }

    @Test
    public void test02() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        WebElement navigator = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(navigator);
        select.selectByIndex(2);
        List<WebElement> priceElements = driver.findElements(By.xpath("div[@class='inventory_item_price']"));
        ArrayList<Double> prices = new ArrayList<>();
        for (WebElement each : priceElements) {
            String priceStr = each.getText().replace("^\\D", "");
            prices.add(Double.parseDouble(priceStr));
        }
        ArrayList<Double> checkList = new ArrayList<>(prices);
        Collections.sort(checkList);
        Assert.assertEquals(prices,checkList);
    }

}
