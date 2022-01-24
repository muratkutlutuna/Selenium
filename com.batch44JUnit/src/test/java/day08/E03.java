package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E03 {
    // ...Exercise3...

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
//fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Gukku");
//fill the firstname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Murti");
//check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
//check the experience
        driver.findElement(By.xpath("//input[@id='exp-3']")).click();
//fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06.03.1992");
//choose your profession -> Automation Tester
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Got it!']")).click();
        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();
//choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
//choose your continent -> Antartica
        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antartica");
//choose your command  -> Browser
        driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']")).click();
        //click submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }
}
