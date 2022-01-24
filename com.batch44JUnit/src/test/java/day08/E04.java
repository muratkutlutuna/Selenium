package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E04 {
    public static void main(String[] args) {
        // ...Exercise5..
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// Navigate to  https://testpages.herokuapp.com/styled/index.html.
        driver.get("https://testpages.herokuapp.com/styled/index.html");
// Click on  Calculate under Micro
        driver.findElement(By.id("calculatetest")).click();
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("25");
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("50");
//    Type any number in the first input
//    Type any number in the second input
// Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
// Get the result
        boolean result = driver.findElement(By.xpath("//span[@id='answer']")).getText().equals("75");
        if (result) {
            System.out.println("Answer PASSED");
        } else {
            System.out.println("Answer FAILED");
        }
        // Print the result
        System.out.println("result = " + result);
    }
}
