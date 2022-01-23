package day05_mavenProjectCreation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//        2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@class='signin btn btn-info']")).click();
//        3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
//        4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
//        5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
//        6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
//        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("3000");
//        8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@class='span4 hasDatepicker']")).sendKeys("2020-09-10");

//        9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
//        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement isSuccessfull = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (isSuccessfull.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        driver.quit();
    }
}
