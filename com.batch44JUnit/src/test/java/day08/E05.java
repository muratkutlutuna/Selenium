package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E05 {
    // ...Exercise4...
// Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the  ORIGINAL CONTENTS
// click on Alerts
// print the URL
// navigate back
// print the URL
// Click on Basic Ajax
// print the URL
// enter value-> 20 and Enter
// and then verify Submitted Values is displayed open page
// close driver
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='alert']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@id='lteq30']")).sendKeys("20" + Keys.ENTER);
        boolean test = driver.findElement(By.xpath("//p[text()='Submitted Values']")).isDisplayed();
        if (test) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }
        driver.quit();
    }


}
